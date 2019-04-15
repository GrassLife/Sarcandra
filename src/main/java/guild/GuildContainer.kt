package guild

import org.bukkit.Bukkit
import java.util.*

class GuildContainer() {

    private val guildSet: MutableSet<Guild> = mutableSetOf()

    fun createGuild(masterUUID: UUID, name: String) {
        if (permitsToCreateBy(masterUUID)) {
            guildSet.add(Guild(masterUUID, listOf(), name))
            Bukkit.getServer().getPlayer(masterUUID)?.sendMessage("Your guild '$name' has been initialized!!")
        }
    }

    fun destroyGuild(masterUUID: UUID) {
        val masterPlayer = Bukkit.getServer().getPlayer(masterUUID) ?: return
        val removedGuild = guildSet.find { it.masterUUID == masterUUID }
        if (removedGuild == null) {
            masterPlayer.sendMessage("You do not have guild.")
            return
        }
        if (guildSet.remove(removedGuild)) {
            masterPlayer.sendMessage("Your guild '${removedGuild.name}' has been dissolved!!")
        } else {
            masterPlayer.sendMessage("Failed to dissolve your guild.")
        }
    }

    fun permitsToCreateBy(builderUUID: UUID): Boolean {
        return guildSet.none { guild -> guild.masterUUID == builderUUID }
    }
}
