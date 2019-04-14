package guild

import org.bukkit.Bukkit
import java.util.*

class GuildContainer(var guildSet: MutableSet<Guild>) {

    fun createGuild(masterUUID: UUID?, name: String?) {
        if (masterUUID == null || name == null) return
        if (isBuildable(masterUUID)) {
            guildSet.add(Guild(masterUUID, listOf(), name))
            Bukkit.getServer().getPlayer(masterUUID)?.sendMessage("Your guild \'$name\' has been initialized!!")
        }
    }

    fun destroyGuild(masterUUID: UUID?) {
        if (masterUUID == null) return
        val guildToRemove = guildSet.find { it.masterUUID == masterUUID }
        val sendPlayer = Bukkit.getServer().getPlayer(masterUUID)
        when (guildSet.remove(guildToRemove)) {
            true -> sendPlayer?.sendMessage("Your guild \'${guildToRemove?.name}\' has been dissolved!!")
            false -> sendPlayer?.sendMessage("Your do not have guild.")
        }
    }

    fun isBuildable(builderUUID: UUID): Boolean {
        return guildSet.filter { it.masterUUID == builderUUID }.isEmpty()
    }
}
