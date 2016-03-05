package my.krbmod.automc.eventhandler;

import java.util.EnumMap;
import java.util.Map;
import my.krbmod.automc.utility.LogHelper;
import net.minecraftforge.event.entity.minecart.MinecartCollisionEvent;
import net.minecraftforge.event.entity.minecart.MinecartEvent;
import net.minecraftforge.event.entity.minecart.MinecartInteractEvent;
import net.minecraftforge.event.entity.minecart.MinecartUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MFEventHandlerEntityMinecart {

	public static String handlerName = "Entity Minecart Event Handler";
	public static boolean eventCounting = true;
	public static boolean eventLogging = true;

	public static EnumMap<MFEventID, MFEvent> localEvents = new EnumMap<MFEventID, MFEvent>(MFEventID.class);

	protected enum MFEventID {
		MINECARTCOLLISION_EVENT, MINECART_EVENT, MINECARTINTERACT_EVENT, MINECARTUPDATE_EVENT
	}

	public static void logEventCounts() {
		if (eventCounting) {
			LogHelper.info(String.format(handlerName+" : %d elements",localEvents.size()));
			for (Map.Entry<MFEventID, MFEvent> thisEvent : localEvents.entrySet()) {
				LogHelper.info(thisEvent.getValue().eventStamp());
			}

		}

	}

	public MFEventHandlerEntityMinecart() {
		LogHelper.info(handlerName+" has been setup");
		localEvents.put(MFEventID.MINECARTCOLLISION_EVENT, new MFEvent("Entity.Minecart: MinecartCollisionEvent", true));
		localEvents.put(MFEventID.MINECART_EVENT, new MFEvent("Entity.Minecart: MinecartEvent", false));
		localEvents.put(MFEventID.MINECARTINTERACT_EVENT, new MFEvent("Entity.Minecart: MinecartInteractEvent", true));
		localEvents.put(MFEventID.MINECARTUPDATE_EVENT, new MFEvent("Entity.Minecart: MinecartUpdateEvent", false));
	}

	/*
	 * MinecartCollisionEvent is fired when a minecart collides with an Entity.
	 */
	@SubscribeEvent
	public void minecartCollisionEvent(MinecartCollisionEvent event) {
		MFEventID currentEventId = MFEventID.MINECARTCOLLISION_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * MinecartEvent is fired whenever an event involving minecart entities
	 * occurs.
	 */
	@SubscribeEvent
	public void minecartEvent(MinecartEvent event) {
		MFEventID currentEventId = MFEventID.MINECART_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * MinecartInteractEvent is fired when a player interacts with a minecart.
	 */
	@SubscribeEvent
	public void minecartInteractEvent(MinecartInteractEvent event) {
		MFEventID currentEventId = MFEventID.MINECARTINTERACT_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * MinecartUpdateEvent is fired when a minecart is updated. This event is
	 * fired whenever a minecart is updated in EntityMinecart#onUpdate().
	 * 
	 * MinecartUpdateEvent.pos contains the coordinate of the track the entity
	 * is on {if applicable}.
	 * 
	 * This event is not Cancelable.
	 * 
	 * This event does not have a result.
	 */
	@SubscribeEvent
	public void minecartUpdateEvent(MinecartUpdateEvent event) {
		MFEventID currentEventId = MFEventID.MINECARTUPDATE_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

}
