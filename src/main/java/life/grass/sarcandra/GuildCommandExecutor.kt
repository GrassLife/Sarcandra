package life.grass.sarcandra

import guild.GuildContainer
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class GuildCommandExecutor(private val guildContainer: GuildContainer) : CommandExecutor {

    public override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (args.isEmpty()) return false
        val senderPlayer = sender as? Player ?: return false
        when (args[0].toUpperCase()) {
            "INIT" -> {
                if (args[1].isNullOrBlank()) {
                    guildContainer.createGuild(senderPlayer.uniqueId, args[1])
                }
            }
            "DISBAND" -> {
                guildContainer.destroyGuild(senderPlayer.uniqueId)
            }
            "INVITE" -> {
                println("invite")
            }
            "CONFIRM" -> {
                println("confirm")
            }
            "LEAVE" -> {
                println("leave")
            }
            else -> return@onCommand false
        }
        return true
    }
}
