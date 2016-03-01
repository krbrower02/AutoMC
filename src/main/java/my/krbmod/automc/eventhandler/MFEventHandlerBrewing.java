package my.krbmod.automc.eventhandler;

import java.util.EnumMap;
import java.util.Map;
import my.krbmod.automc.utility.LogHelper;
import net.minecraftforge.event.brewing.PotionBrewEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MFEventHandlerBrewing {

	public static String handlerName = "Brewing Event Handler";
	public static boolean eventCounting = true;
	public static boolean eventLogging = true;
	public static MFEventId currentEventId;

	public static EnumMap<MFEventId, MFEvent> localEvents = new EnumMap<MFEventId, MFEvent>(
			MFEventId.class);

	protected enum MFEventId {
		//POTIONBREW_EVENT  - do not subscribe to parent event 
		POTIONBREW_EVENT_POST, POTIONBREW_EVENT_PRE
	}

	public static void logEventCounts() {
		if (eventCounting) {
			LogHelper.info(String.format(handlerName+" : %d elements",localEvents.size()));
			for (Map.Entry<MFEventId, MFEvent> thisEvent : localEvents.entrySet()) {
				LogHelper.info(thisEvent.getValue().eventStamp());
			}

		}

	}

	public MFEventHandlerBrewing() {
		LogHelper.info(handlerName+" has been setup");
		//localEvents.put(MFEventId.POTIONBREW_EVENT, new MFEvent("Potion Brew Event", false));
		localEvents.put(MFEventId.POTIONBREW_EVENT_POST, new MFEvent("Potion Brew Event - Post", true));
		localEvents.put(MFEventId.POTIONBREW_EVENT_PRE, new MFEvent("Potion Brew Event - Pre", true));
	}

	/*
	 * PotionBrewEvent.Post is fired when a potion is brewed in the brewing
	 * stand.
	 * 
	 */
	@SubscribeEvent
	public void potionBrewEventPost(PotionBrewEvent.Post event) {
		currentEventId = MFEventId.POTIONBREW_EVENT_POST;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * PotionBrewEvent.Pre is fired before vanilla brewing takes place.
	 * 
	 */
	@SubscribeEvent
	public void potionBrewEventPre(PotionBrewEvent.Pre event) {
		currentEventId = MFEventId.POTIONBREW_EVENT_PRE;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

}
