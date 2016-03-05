package my.krbmod.automc.eventhandler;

import java.util.EnumMap;
import java.util.Map;

import my.krbmod.automc.utility.LogHelper;
import net.minecraftforge.event.entity.item.ItemEvent;
import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MFEventHandlerEntityItem {

	public static String handlerName = "Item Event Handler";
	public static boolean eventCounting = true;
	public static boolean eventLogging = true;

	public static EnumMap<MFEventID, MFEvent> localEvents = new EnumMap<MFEventID, MFEvent>(
			MFEventID.class);

	protected enum MFEventID {
		ITEM_EVENT, ITEMEXPIRE_EVENT, ITEMTOSS_EVENT
	}

	public static void logEventCounts() {
		if (eventCounting) {
			LogHelper.info(String.format(handlerName+" : %d elements",localEvents.size()));
			for (Map.Entry<MFEventID, MFEvent> thisEvent : localEvents.entrySet()) {
				LogHelper.info(thisEvent.getValue().eventStamp());
			}

		}

	}

	public MFEventHandlerEntityItem() {
		LogHelper.info(handlerName+" has been setup");
		localEvents.put(MFEventID.ITEM_EVENT, new MFEvent("Entity.Item: Item", false));
		localEvents.put(MFEventID.ITEMEXPIRE_EVENT, new MFEvent("Entity.Item: Item Expire", true));
		localEvents.put(MFEventID.ITEMTOSS_EVENT, new MFEvent("Entity.Item: Item Toss", true));
	}

	/*
	 * Base class for all EntityItem events.
	 * 
	 */
	@SubscribeEvent
	public void itemEvent(ItemEvent event) {
		MFEventID currentEventId = MFEventID.ITEM_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
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
		MFEventID currentEventId = MFEventID.ITEMEXPIRE_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
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
		MFEventID currentEventId = MFEventID.ITEMTOSS_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

}
