package f3f5.govno.mishaantidupe

import org.bukkit.Bukkit
import org.bukkit.entity.*
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.plugin.java.JavaPlugin

class MishaAntiDupe : JavaPlugin(), Listener {

    override fun onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this)
    }

    @EventHandler
    fun onDamage(event: EntityDamageByEntityEvent) {
        if (event.damager is Projectile && event.entity is Player) {
            val projectile = event.damager as Projectile
            val player = event.entity as Player

            if ((projectile is Arrow || projectile is Snowball || projectile is FishHook || projectile is Egg)
                && projectile.shooter == player) {

                event.isCancelled = true
            }
        }
    }
}