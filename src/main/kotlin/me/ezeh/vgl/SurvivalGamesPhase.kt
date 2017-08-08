package me.ezeh.vgl

import com.voxelgameslib.voxelgameslib.feature.features.*
import com.voxelgameslib.voxelgameslib.phase.AbstractPhase
import org.bukkit.GameMode;



class SurvivalGamesPhase: AbstractPhase() {
    override fun init() {
        super.init()
        setAllowJoin(false)
        setAllowSpectate(true)

        val mapFeature = game.createFeature(MapFeature::class.java, this)
        mapFeature.setShouldUnload(true)
        addFeature(mapFeature)

        val spawnFeature = game.createFeature(SpawnFeature::class.java, this)
        addFeature(spawnFeature)

        val noBlockBreakFeature = game.createFeature(NoBlockBreakFeature::class.java, this)
        addFeature(noBlockBreakFeature)

        val noBlockPlaceFeature = game.createFeature(NoBlockPlaceFeature::class.java, this)
        addFeature(noBlockPlaceFeature)

        val gameModeFeature = game.createFeature(GameModeFeature::class.java, this)
        gameModeFeature.setGameMode(GameMode.SURVIVAL)
        addFeature(gameModeFeature)

        val scoreboardFeature = game.createFeature(ScoreboardFeature::class.java, this)
        addFeature(scoreboardFeature)
        val survivalGamesFeature = game.createFeature(SurvivalGamesFeature::class.java, this)
    }

}