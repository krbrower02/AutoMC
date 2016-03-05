package my.krbmod.automc.eventhandler;

import java.util.EnumMap;
import java.util.Map;

import my.krbmod.automc.utility.LogHelper;
import net.minecraftforge.event.entity.item.ItemEvent;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHealEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingPackSizeEvent;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.entity.living.ZombieEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MFEventHandlerEntityLiving {

	public static String handlerName = "Entity Living Event Handler";
	public static boolean eventCounting = true;
	public static boolean eventLogging = true;

	public static EnumMap<MFEventID, MFEvent> localEvents = new EnumMap<MFEventID, MFEvent>(
			MFEventID.class);

	protected enum MFEventID {
		ENDERTELEPORT_EVENT, LIVINGATTACK_EVENT, LIVINGDEATH_EVENT, LIVINGDROPS_EVENT, 
		//LIVING_EVENT - do not subscribe to parent event 
		LIVING_EVENT_LIVINGJUMP_EVENT, LIVING_EVENT_LIVINGUPDATE_EVENT, LIVINGEXPERIENCEDROP_EVENT, LIVINGFALL_EVENT, LIVINGHEAL_EVENT, LIVINGHURT_EVENT, LIVINGPACKSIZE_EVENT, LIVINGSETATTACKTARGET_EVENT, 
		//LIVINGSPAWN_EVENT - do not subscribe to parent event
		LIVINGSPAWN_EVENT_ALLOWDESPAWN, LIVINGSPAWN_EVENT_CHECKSPAWN, LIVINGSPAWN_EVENT_SPECIALSPAWN, 
		//ZOMBIE_EVENT - do not subscribe to parent event
		ZOMBIE_EVENT_SUMMONAID_EVENT

	}

	public static void logEventCounts() {
		if (eventCounting) {
			LogHelper.info(String.format(handlerName+" : %d elements",localEvents.size()));
			for (Map.Entry<MFEventID, MFEvent> thisEvent : localEvents.entrySet()) {
				LogHelper.info(thisEvent.getValue().eventStamp());
			}

		}

	}

	public MFEventHandlerEntityLiving() {
		LogHelper.info(handlerName+" has been setup");
		localEvents.put(MFEventID.ENDERTELEPORT_EVENT, new MFEvent("Entity.Living: Ender Teleport Event", false));
		localEvents.put(MFEventID.LIVINGATTACK_EVENT, new MFEvent("Entity.Living: Living Attack Event", false));
		localEvents.put(MFEventID.LIVINGDEATH_EVENT, new MFEvent("Entity.Living: Living Death Event", true));
		localEvents.put(MFEventID.LIVINGDROPS_EVENT, new MFEvent("Entity.Living: Living Drops Event", true));
		localEvents.put(MFEventID.LIVING_EVENT_LIVINGJUMP_EVENT,
				new MFEvent("Entity.Living: Living Event - Living Jump Event", false));
		localEvents.put(MFEventID.LIVING_EVENT_LIVINGUPDATE_EVENT,
				new MFEvent("Entity.Living: Living Event - Living Update Event", false));
		localEvents.put(MFEventID.LIVINGEXPERIENCEDROP_EVENT, new MFEvent("Entity.Living: Living Experience Drop Event", true));
		localEvents.put(MFEventID.LIVINGFALL_EVENT, new MFEvent("Entity.Living: Living Fall Event", false));
		localEvents.put(MFEventID.LIVINGHEAL_EVENT, new MFEvent("Entity.Living: Living Heal Event", true));
		localEvents.put(MFEventID.LIVINGHURT_EVENT, new MFEvent("Entity.Living: Living Hurt Event", true));
		localEvents.put(MFEventID.LIVINGPACKSIZE_EVENT, new MFEvent("Entity.Living: Living Pack Size Event", false));
		localEvents.put(MFEventID.LIVINGSETATTACKTARGET_EVENT,
				new MFEvent("Entity.Living: Living Set Attack Target Event", true));
		localEvents.put(MFEventID.LIVINGSPAWN_EVENT_ALLOWDESPAWN,
				new MFEvent("Entity.Living: Living Spawn Event - Allow Despawn", false));
		localEvents.put(MFEventID.LIVINGSPAWN_EVENT_CHECKSPAWN,
				new MFEvent("Entity.Living: Living Spawn Event - Check Spawn", false));
		localEvents.put(MFEventID.LIVINGSPAWN_EVENT_SPECIALSPAWN,
				new MFEvent("Entity.Living: Living Spawn Event - Special Spawn", true));
		localEvents.put(MFEventID.ZOMBIE_EVENT_SUMMONAID_EVENT,
				new MFEvent("Entity.Living: Zombie Event - Summon Aid Event", true));
	}

	/*
	 * Event for when an Enderman teleports or an ender pearl is used.
	 * 
	 */
	@SubscribeEvent
	public void enderTeleportEvent(EnderTeleportEvent event) {
		MFEventID currentEventId = MFEventID.ENDERTELEPORT_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * LivingAttackEvent is fired when a living Entity is attacked.
	 * 
	 */
	@SubscribeEvent
	public void livingAttackEvent(LivingAttackEvent event) {
		MFEventID currentEventId = MFEventID.LIVINGATTACK_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * LivingDeathEvent is fired when an Entity dies.
	 * 
	 */
	@SubscribeEvent
	public void livingDeathEvent(LivingDeathEvent event) {
		MFEventID currentEventId = MFEventID.LIVINGDEATH_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * LivingDropsEvent is fired when an Entity's death causes dropped items to
	 * appear. This event is fired whenever an Entity dies and drops items in
	 * EntityLivingBase#onDeath(DamageSource).
	 * 
	 * This event is fired via the ForgeHooks#onLivingDrops(EntityLivingBase,
	 * DamageSource, ArrayList, int, boolean, int).
	 * 
	 * LivingDropsEvent.source contains the DamageSource that caused the drop to
	 * occur. LivingDropsEvent.drops contains the ArrayList of EntityItems that
	 * will be dropped. LivingDropsEvent.lootingLevel contains the amount of
	 * loot that will be dropped. LivingDropsEvent.recentlyHit determines
	 * whether the Entity doing the drop has recently been damaged.
	 * 
	 * This event is Cancelable. If this event is canceled, the Entity does not
	 * drop anything.
	 * 
	 * This event does not have a result.
	 * 
	 */
	@SubscribeEvent
	public void livingDropsEvent(LivingDropsEvent event) {
		MFEventID currentEventId = MFEventID.LIVINGDROPS_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * LivingEvent is fired whenever an event involving Living entities occurs.
	 * If a method utilizes this Event as its parameter, the method will receive
	 * every child event of this class.
	 * 
	 * All children of this event are fired on the MinecraftForge#EVENT_BUS.
	 * 
	*/

	
	/*
	 * LivingJumpEvent is fired when an Entity jumps. This event is fired
	 * whenever an Entity jumps in EntityLivingBase#jump(),
	 * EntityMagmaCube#jump(), and EntityHorse#jump().
	 * 
	 * This event is fired via the ForgeHooks#onLivingJump(EntityLivingBase).
	 * 
	 * This event is not Cancelable.
	 * 
	 * This event does not have a result.
	 * 
	 */
	@SubscribeEvent
	public void livingEventlivingJumpEvent(LivingEvent.LivingJumpEvent event) {
		MFEventID currentEventId = MFEventID.LIVING_EVENT_LIVINGJUMP_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * LivingUpdateEvent is fired when an Entity is updated.
	 * 
	 */
	@SubscribeEvent
	public void livingEventlivingUpdateEvent(LivingEvent.LivingUpdateEvent event) {
		MFEventID currentEventId = MFEventID.LIVING_EVENT_LIVINGUPDATE_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * Event for when an entity drops experience on its death, can be used to
	 * change the amount of experience points dropped or completely prevent
	 * dropping of experience by canceling the event.
	 * 
	 */
	@SubscribeEvent
	public void livingExperienceDropEvent(LivingExperienceDropEvent event) {
		MFEventID currentEventId = MFEventID.LIVINGEXPERIENCEDROP_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * LivingFallEvent is fired when an Entity is set to be falling. This event
	 * is fired whenever an Entity is set to fall in
	 * EntityLivingBase#fall(float).
	 * 
	 * This event is fired via the ForgeHooks#onLivingFall(EntityLivingBase,
	 * float).
	 * 
	 * LivingFallEvent.distance contains the distance the Entity is to fall.
	 * 
	 */
	@SubscribeEvent
	public void livingFallEvent(LivingFallEvent event) {
		MFEventID currentEventId = MFEventID.LIVINGFALL_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * LivingHealEvent is fired when an Entity is set to be healed.
	 * 
	 */
	@SubscribeEvent
	public void livingHealEvent(LivingHealEvent event) {
		MFEventID currentEventId = MFEventID.LIVINGHEAL_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * LivingHurtEvent is fired when an Entity is set to be hurt.
	 * 
	 */
	@SubscribeEvent
	public void livingHurtEvent(LivingHurtEvent event) {
		MFEventID currentEventId = MFEventID.LIVINGHURT_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * 
	 */
	@SubscribeEvent
	public void livingPackSizeEvent(LivingPackSizeEvent event) {
		MFEventID currentEventId = MFEventID.LIVINGPACKSIZE_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * LivingSetAttackTargetEvent is fired when an Entity sets a target to
	 * attack. This event is fired whenever an Entity sets a target to attack in
	 * EntityLiving#setAttackTarget(EntityLivingBase) and
	 * EntityLivingBase#setRevengeTarget(EntityLivingBase).
	 * 
	 * This event is fired via the
	 * ForgeHooks#onLivingSetAttackTarget(EntityLivingBase, EntityLivingBase).
	 * 
	 * LivingSetAttackTargetEvent.target contains the newly targeted Entity.
	 * 
	 * This event is not Cancelable.
	 * 
	 * This event does not have a result.
	 * 
	 */
	@SubscribeEvent
	public void livingSetAttackTargetEvent(LivingSetAttackTargetEvent event) {
		MFEventID currentEventId = MFEventID.LIVINGSETATTACKTARGET_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * LivingSpawnEvent is fired whenever a living Entity is spawned.
	 *
	 */


	/*
	 * Fired each tick for despawnable mobs to allow control over despawning.
	 * 
	 */
	@SubscribeEvent
	public void livingSpawnEventAllowDespawn(LivingSpawnEvent.AllowDespawn event) {
		MFEventID currentEventId = MFEventID.LIVINGSPAWN_EVENT_ALLOWDESPAWN;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * Fires before mob spawn events. SpecialSpawn is fired when an Entity is to
	 * be spawned from a mob spawner. This event is fired whenever an Entity is
	 * spawned in a mob spawner in
	 * SpawnerAnimals#findChunksForSpawning(WorldServer, boolean, boolean,
	 * boolean).
	 * 
	 */
	@SubscribeEvent
	public void livingSpawnEventCheckSpawn(LivingSpawnEvent.CheckSpawn event) {
		MFEventID currentEventId = MFEventID.LIVINGSPAWN_EVENT_CHECKSPAWN;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * This event is fired via the ForgeHooks#doSpecialSpawn(EntityLiving,
	 * World, float, float, float).
	 * 
	 * This event is Cancelable. If this event is canceled, the Entity is not
	 * spawned.
	 * 
	 * This event does not have a result.
	 * 
	 */
	@SubscribeEvent
	public void livingSpawnEventSpecialSpawn(LivingSpawnEvent.SpecialSpawn event) {
		MFEventID currentEventId = MFEventID.LIVINGSPAWN_EVENT_SPECIALSPAWN;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * ZombieEvent is fired whenever a zombie is spawned for aid.
	 * 
	*/

	/*
	 * SummonAidEvent is fired when a Zombie Entity is summoned.
	 * 
	 */
	@SubscribeEvent
	public void zombieEventSummonAidEvent(ZombieEvent.SummonAidEvent event) {
		MFEventID currentEventId = MFEventID.ZOMBIE_EVENT_SUMMONAID_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

}
