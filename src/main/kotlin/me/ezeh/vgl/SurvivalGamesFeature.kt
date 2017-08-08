package me.ezeh.vgl

import com.voxelgameslib.voxelgameslib.event.GameEvent
import com.voxelgameslib.voxelgameslib.feature.AbstractFeature
import org.bukkit.ChatColor
import org.bukkit.entity.Player
import org.bukkit.event.entity.PlayerDeathEvent
import java.util.*


class SurvivalGamesFeature : AbstractFeature() {
    val dead = HashSet<UUID>()
    override fun start() {
        println("Survival feature")
    }

    @GameEvent
    fun onKill(event: PlayerDeathEvent) {
        if (event.entity.killer !is Player) return
        val player = event.entity
        val killer = event.entity.killer
        dead.add(player.uniqueId)
        phase.game.allUsers.map { it.player.sendMessage(ChatColor.ITALIC + "${ChatColor.RED + player.displayName} has been killed by ${ChatColor.BLACK + killer.displayName}") }
        if (phase.game.allUsers.filter { !dead.contains(it.uuid) }.size == 1) {
            println("Ending game as only one player remains")// debug code
            stop()
        }
    }

    override fun stop() {
        println("Stopping")
    }

    override fun init() {
        println("Initialisation of SurvivalGamesFeature")
    }

    override fun tick() {

    }

    private operator fun ChatColor.plus(s: String): String {
        return "" + this.toString() + s
    }

}
