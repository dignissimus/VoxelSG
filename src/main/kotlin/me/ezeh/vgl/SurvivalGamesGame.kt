package me.ezeh.vgl

import com.voxelgameslib.voxelgameslib.game.AbstractGame
import com.voxelgameslib.voxelgameslib.phase.phases.GracePhase
import com.voxelgameslib.voxelgameslib.phase.phases.LobbyPhase
import com.voxelgameslib.voxelgameslib.phase.phases.LobbyWithVotePhase
import com.voxelgameslib.voxelgameslib.game.GameDefinition
import com.voxelgameslib.voxelgameslib.game.GameInfo

@GameInfo(name = "Survival Games", author = "spammy23", version = "1.0", description = "A generic Survival Games Minigame")
class SurvivalGamesGame : AbstractGame(SurvivalGames.GAMEMODE) {
    override fun initGameFromModule() {
        minPlayers = 2 // TODO set to 4 after testing
        maxPlayers = 16
        val lobbyPhase = createPhase(LobbyPhase::class.java)
        val votePhase = createPhase(LobbyWithVotePhase::class.java)
        val gracePhase = createPhase(GracePhase::class.java)
        val survivalGamesPhase = createPhase(SurvivalGamesPhase::class.java)

        lobbyPhase.nextPhase = votePhase
        votePhase.nextPhase = gracePhase
        gracePhase.nextPhase = survivalGamesPhase

        activePhase = lobbyPhase
        init()
    }

    override fun initGameFromDefinition(gameDefinition: GameDefinition) {
        super.initGameFromDefinition(gameDefinition)
        init()
    }

    fun init() {
        loadMap()
    }

}

