package uk.antiperson.stackmob.listeners.entity;

import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTameEvent;
import uk.antiperson.stackmob.StackMob;
import uk.antiperson.stackmob.entity.StackTools;

public class TameEvent implements Listener {

    private StackMob sm;

    public TameEvent(StackMob sm) {
        this.sm = sm;
    }

    @EventHandler
    public void onTame(EntityTameEvent event) {
        Entity entity = event.getEntity();
        if(StackTools.hasValidStackData(entity)){
            int stackSize = StackTools.getSize(entity);
            if(stackSize > 1){
                Entity dupe = sm.tools.duplicate(entity);
                StackTools.setSize(dupe, stackSize - 1);
            }
            StackTools.removeSize(entity);
        }
    }
}
