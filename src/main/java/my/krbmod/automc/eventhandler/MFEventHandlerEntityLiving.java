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
	public static MFEventId currentEventId;

	public static EnumMap<MFEventId, MFEvent> localEvents = new EnumMap<MFEventId, MFEvent>(
			MFEventId.class);

	protected enum MFEventId {
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
			for (Map.Entry<MFEventId, MFEvent> thisEvent : localEvents.entrySet()) {
				LogHelper.info(thisEvent.getValue().eventStamp());
			}

		}

	}

	public MFEventHandlerEntityLiving() {
		LogHelper.info(handlerName+" has been setup");
		localEvents.put(MFEventId.ENDERTELEPORT_EVENT, new MFEvent("Ender Teleport Event", false));
		localEvents.put(MFEventId.LIVINGATTACK_EVENT, new MFEvent("Living Attack Event", false));
		localEvents.put(MFEventId.LIVINGDEATH_EVENT, new MFEvent("Living Death Event", true));
		localEvents.put(MFEventId.LIVINGDROPS_EVENT, new MFEvent("Living Drops Event", true));
		localEvents.put(MFEventId.LIVING_EVENT_LIVINGJUMP_EVENT,
				new MFEvent("Living Event - Living Jump Event", false));
		localEvents.put(MFEventId.LIVING_EVENT_LIVINGUPDATE_EVENT,
				new MFEvent("Living Event - Living Update Event", false));
		localEvents.put(MFEventId.LIVINGEXPERIENCEDROP_EVENT, new MFEvent("Living Experience Drop Event", true));
		localEvents.put(MFEventId.LIVINGFALL_EVENT, new MFEvent("Living Fall Event", false));
		localEvents.put(MFEventId.LIVINGHEAL_EVENT, new MFEvent("Living Heal Event", true));
		localEvents.put(MFEventId.LIVINGHURT_EVENT, new MFEvent("Living Hurt Event", true));
		localEvents.put(MFEventId.LIVINGPACKSIZE_EVENT, new MFEvent("Living Pack Size Event", true));
		localEvents.put(MFEventId.LIVINGSETATTACKTARGET_EVENT,
				new MFEvent("Living Set Attack Target Event", true));
		localEvents.put(MFEventId.LIVINGSPAWN_EVENT_ALLOWDESPAWN,
				new MFEvent("Living Spawn Event - Allow Despawn", false));
		localEvents.put(MFEventId.LIVINGSPAWN_EVENT_CHECKSPAWN,
				new MFEvent("Living Spawn Event - Check Spawn", false));
		localEvents.put(MFEventId.LIVINGSPAWN_EVENT_SPECIALSPAWN,
				new MFEvent("Living Spawn Event - Special Spawn", true));
		localEvents.put(MFEventId.ZOMBIE_EVENT_SUMMONAID_EVENT,
				new MFEvent("Zombie Event - Summon Aid Event", true));
	}

	/*
	 * Event for when an Enderman teleports or an ender pearl is used.
	 * 
	 */
	@SubscribeEvent
	public void enderTeleportEvent(EnderTeleportEvent event) {
		currentEventId = MFEventId.ENDERTELEPORT_EVENT;

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
		currentEventId = MFEventId.LIVINGATTACK_EVENT;

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
		currentEventId = MFEventId.LIVINGDEATH_EVENT;

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
		currentEventId = MFEventId.LIVINGDROPS_EVENT;

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
		currentEventId = MFEventId.LIVING_EVENT_LIVINGJUMP_EVENT;

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
		currentEventId = MFEventId.LIVING_EVENT_LIVINGUPDATE_EVENT;

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
		currentEventId = MFEventId.LIVINGEXPERIENCEDROP_EVENT;

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
		currentEventId = MFEventId.LIVINGFALL_EVENT;

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
		currentEventId = MFEventId.LIVINGHEAL_EVENT;

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
		currentEventId = MFEventId.LIVINGHURT_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * 
	 */
	@SubscribeEvent
	public void livingPackSizeEvent(LivingPackSizeEvent event) {
		currentEventId = MFEventId.LIVINGPACKSIZE_EVENT;

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
		currentEventId = MFEventId.LIVINGSETATTACKTARGET_EVENT;

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
		currentEventId = MFEventId.LIVINGSPAWN_EVENT_ALLOWDESPAWN;

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
		currentEventId = MFEventId.LIVINGSPAWN_EVENT_CHECKSPAWN;

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
		currentEventId = MFEventId.LIVINGSPAWN_EVENT_SPECIALSPAWN;

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
		currentEventId = MFEventId.ZOMBIE_EVENT_SUMMONAID_EVENT;

		MFEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

}
