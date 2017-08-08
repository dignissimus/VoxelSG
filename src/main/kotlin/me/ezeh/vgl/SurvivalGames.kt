package me.ezeh.vgl

import com.google.inject.Singleton
import com.voxelgameslib.voxelgameslib.game.GameHandler
import com.voxelgameslib.voxelgameslib.module.Module
import com.voxelgameslib.voxelgameslib.game.GameMode
import com.voxelgameslib.voxelgameslib.module.ModuleInfo
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.plugin.java.JavaPlugin
import javax.inject.Inject
import com.voxelgameslib.voxelgameslib.module.ModuleHandler



@Singleton
@ModuleInfo(name = "SurvivalGames", authors = arrayOf("spammy23"), version = "1.0")
class SurvivalGames : JavaPlugin(), Module{
    @Inject
    private lateinit var gameHandler: GameHandler

    companion object {
        val GAMEMODE = GameMode("SurvivalGames", SurvivalGamesGame::class.java)
    }

    override fun onLoad() {
        ModuleHandler.offerModule(this)
    }

    override fun disable() {

    }

    override fun enable() {
        gameHandler.registerGameMode(GAMEMODE)
    }
}