package life.grass.sarcandra

import guild.GuildContainer
import org.bukkit.plugin.java.JavaPlugin

class Sarcandra : JavaPlugin() {

    override fun onEnable() {
        super.onEnable()
        getCommand("sarcandra-guild")?.setExecutor(GuildCommandExecutor(GuildContainer(mutableSetOf())))
    }

}