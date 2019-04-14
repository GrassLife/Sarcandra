package life.grass.sarcandra

import guild.GuildContainer
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class GuildCommandExecutor(val guildContainer: GuildContainer) : CommandExecutor {

    public override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (args.isEmpty()) return false
        val senderPlayer = sender.server.getPlayer(sender.name)
        return when (args[0].toUpperCase()) {
            "INIT" -> {
                guildContainer.createGuild(senderPlayer?.uniqueId, args[1])
                true
            }
            "DISSOLVE" -> {
                guildContainer.destroyGuild(senderPlayer?.uniqueId)
                true
            }
            "INVITE" -> {
                println("invite")
                true
            }
            "CONFIRM" -> {
                println("confirm")
                true
            }
            else -> false
        }
    }
}
