package my.krbmod.automc.eventhandler;

import java.util.EnumMap;
import java.util.Map;

import my.krbmod.automc.eventhandler.EntityPlayerEventHandler.LocalEventId;
import my.krbmod.automc.utility.LogHelper;
import net.minecraftforge.event.entity.item.ItemEvent;
import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EntityItemEventHandler {

	public static boolean eventCounting = true;
	public static boolean eventLogging = true;
	public static LocalEventId currentEventId;

	public static EnumMap<LocalEventId, LocalEvent> localEvents = new EnumMap<LocalEventId, LocalEvent>(
			LocalEventId.class);

	protected enum LocalEventId {
		ITEM_EVENT, ITEMEXPIRE_EVENT, ITEMTOSS_EVENT
	}

	public static void logEventCounts() {
		if (eventCounting) {
			for (Map.Entry<LocalEventId, LocalEvent> thisEvent : localEvents.entrySet()) {
				LogHelper.info(thisEvent.getValue().eventStamp());
			}

		}

	}

	public EntityItemEventHandler() {
		LogHelper.info("Item Event Handler has been setup");
		localEvents.put(LocalEventId.ITEM_EVENT, new LocalEvent("Item", false));
		localEvents.put(LocalEventId.ITEMEXPIRE_EVENT, new LocalEvent("Item Expire", true));
		localEvents.put(LocalEventId.ITEMTOSS_EVENT, new LocalEvent("Item Toss", true));
	}

	/*
	 * Base class for all EntityItem events.
	 * 
	 */
	@SubscribeEvent
	public void itemEvent(ItemEvent event) {
		currentEventId = LocalEventId.ITEM_EVENT;

		LocalEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * Event that is fired when an EntityItem's age has reached its maximum
	 * lifespan.
	 * 
	 */
	@SubscribeEvent
	public void itemExpireEvent(ItemExpireEvent event) {
		currentEventId = LocalEventId.ITEMEXPIRE_EVENT;

		LocalEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * Event that is fired whenever a player tosses (Q) an item or drag-n-drops
	 * a stack of items outside the inventory GUI screens.
	 * 
	 */
	@SubscribeEvent
	public void itemTossEvent(ItemTossEvent event) {
		currentEventId = LocalEventId.ITEMTOSS_EVENT;

		LocalEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

}
