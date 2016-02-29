package my.krbmod.automc.eventhandler;

import java.util.EnumMap;
import java.util.Map;

import my.krbmod.automc.eventhandler.EntityPlayerEventHandler.LocalEventId;
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

public class EntityLivingEventHandler {

	public static boolean eventCounting = true;
	public static boolean eventLogging = true;
	public static LocalEventId currentEventId;

	public static EnumMap<LocalEventId, LocalEvent> localEvents = new EnumMap<LocalEventId, LocalEvent>(
			LocalEventId.class);

	protected enum LocalEventId {
		ENDERTELEPORT_EVENT, LIVINGATTACK_EVENT, LIVINGDEATH_EVENT, LIVINGDROPS_EVENT, LIVING_EVENT, LIVING_EVENT_LIVINGJUMP_EVENT, LIVING_EVENT_LIVINGUPDATE_EVENT, LIVINGEXPERIENCEDROP_EVENT, LIVINGFALL_EVENT, LIVINGHEAL_EVENT, LIVINGHURT_EVENT, LIVINGPACKSIZE_EVENT, LIVINGSETATTACKTARGET_EVENT, LIVINGSPAWN_EVENT, LIVINGSPAWN_EVENT_ALLOWDESPAWN, LIVINGSPAWN_EVENT_CHECKSPAWN, LIVINGSPAWN_EVENT_SPECIALSPAWN, ZOMBIE_EVENT, ZOMBIE_EVENT_SUMMONAID_EVENT

	}

	public static void logEventCounts() {
		if (eventCounting) {
			for (Map.Entry<LocalEventId, LocalEvent> thisEvent : localEvents.entrySet()) {
				LogHelper.info(thisEvent.getValue().eventStamp());
			}

		}

	}

	public EntityLivingEventHandler() {
		LogHelper.info("Entity Living Event Handler has been setup");
		localEvents.put(LocalEventId.ENDERTELEPORT_EVENT, new LocalEvent("Ender Teleport Event", false));
		localEvents.put(LocalEventId.LIVINGATTACK_EVENT, new LocalEvent("Living Attack Event", false));
		localEvents.put(LocalEventId.LIVINGDEATH_EVENT, new LocalEvent("Living Death Event", false));
		localEvents.put(LocalEventId.LIVINGDROPS_EVENT, new LocalEvent("Living Drops Event", false));
		localEvents.put(LocalEventId.LIVING_EVENT, new LocalEvent("Living Event", false));
		localEvents.put(LocalEventId.LIVING_EVENT_LIVINGJUMP_EVENT,
				new LocalEvent("Living Event - Living Jump Event", false));
		localEvents.put(LocalEventId.LIVING_EVENT_LIVINGUPDATE_EVENT,
				new LocalEvent("Living Event - Living Update Event", false));
		localEvents.put(LocalEventId.LIVINGEXPERIENCEDROP_EVENT, new LocalEvent("Living Experience Drop Event", false));
		localEvents.put(LocalEventId.LIVINGFALL_EVENT, new LocalEvent("Living Fall Event", false));
		localEvents.put(LocalEventId.LIVINGHEAL_EVENT, new LocalEvent("Living Heal Event", false));
		localEvents.put(LocalEventId.LIVINGHURT_EVENT, new LocalEvent("Living Hurt Event", false));
		localEvents.put(LocalEventId.LIVINGPACKSIZE_EVENT, new LocalEvent("Living Pack Size Event", false));
		localEvents.put(LocalEventId.LIVINGSETATTACKTARGET_EVENT,
				new LocalEvent("Living Set Attack Target Event", false));
		localEvents.put(LocalEventId.LIVINGSPAWN_EVENT, new LocalEvent("Living Spawn Event", false));
		localEvents.put(LocalEventId.LIVINGSPAWN_EVENT_ALLOWDESPAWN,
				new LocalEvent("Living Spawn Event - Allow Despawn", false));
		localEvents.put(LocalEventId.LIVINGSPAWN_EVENT_CHECKSPAWN,
				new LocalEvent("Living Spawn Event - Check Spawn", false));
		localEvents.put(LocalEventId.LIVINGSPAWN_EVENT_SPECIALSPAWN,
				new LocalEvent("Living Spawn Event - Special Spawn", false));
		localEvents.put(LocalEventId.ZOMBIE_EVENT, new LocalEvent("Zombie Event", false));
		localEvents.put(LocalEventId.ZOMBIE_EVENT_SUMMONAID_EVENT,
				new LocalEvent("Zombie Event - Summon Aid Event", false));
	}

	/*
	 * Event for when an Enderman teleports or an ender pearl is used.
	 * 
	 */
	@SubscribeEvent
	public void enderTeleportEvent(EnderTeleportEvent event) {
		currentEventId = LocalEventId.ENDERTELEPORT_EVENT;

		LocalEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * LivingAttackEvent is fired when a living Entity is attacked.
	 * 
	 */
	@SubscribeEvent
	public void livingAttackEvent(LivingAttackEvent event) {
		currentEventId = LocalEventId.LIVINGATTACK_EVENT;

		LocalEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * LivingDeathEvent is fired when an Entity dies.
	 * 
	 */
	@SubscribeEvent
	public void livingDeathEvent(LivingDeathEvent event) {
		currentEventId = LocalEventId.LIVINGDEATH_EVENT;

		LocalEvent thisEvent = localEvents.get(currentEventId);
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
		currentEventId = LocalEventId.LIVINGDROPS_EVENT;

		LocalEvent thisEvent = localEvents.get(currentEventId);
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
	@SubscribeEvent
	public void livingEvent(LivingEvent event) {
		currentEventId = LocalEventId.LIVING_EVENT;

		LocalEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

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
		currentEventId = LocalEventId.LIVING_EVENT_LIVINGJUMP_EVENT;

		LocalEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * LivingUpdateEvent is fired when an Entity is updated.
	 * 
	 */
	@SubscribeEvent
	public void livingEventlivingUpdateEvent(LivingEvent.LivingUpdateEvent event) {
		currentEventId = LocalEventId.LIVING_EVENT_LIVINGUPDATE_EVENT;

		LocalEvent thisEvent = localEvents.get(currentEventId);
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
		currentEventId = LocalEventId.LIVINGEXPERIENCEDROP_EVENT;

		LocalEvent thisEvent = localEvents.get(currentEventId);
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
		currentEventId = LocalEventId.LIVINGFALL_EVENT;

		LocalEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * LivingHealEvent is fired when an Entity is set to be healed.
	 * 
	 */
	@SubscribeEvent
	public void livingHealEvent(LivingHealEvent event) {
		currentEventId = LocalEventId.LIVINGHEAL_EVENT;

		LocalEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * LivingHurtEvent is fired when an Entity is set to be hurt.
	 * 
	 */
	@SubscribeEvent
	public void livingHurtEvent(LivingHurtEvent event) {
		currentEventId = LocalEventId.LIVINGHURT_EVENT;

		LocalEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * 
	 */
	@SubscribeEvent
	public void livingPackSizeEvent(LivingPackSizeEvent event) {
		currentEventId = LocalEventId.LIVINGPACKSIZE_EVENT;

		LocalEvent thisEvent = localEvents.get(currentEventId);
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
		currentEventId = LocalEventId.LIVINGSETATTACKTARGET_EVENT;

		LocalEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * LivingSpawnEvent is fired whenever a living Entity is spawned.
	 * 
	 */
	@SubscribeEvent
	public void livingSpawnEvent(LivingSpawnEvent event) {
		currentEventId = LocalEventId.LIVINGSPAWN_EVENT;

		LocalEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * Fired each tick for despawnable mobs to allow control over despawning.
	 * 
	 */
	@SubscribeEvent
	public void livingSpawnEventAllowDespawn(LivingSpawnEvent.AllowDespawn event) {
		currentEventId = LocalEventId.LIVINGSPAWN_EVENT_ALLOWDESPAWN;

		LocalEvent thisEvent = localEvents.get(currentEventId);
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
		currentEventId = LocalEventId.LIVINGSPAWN_EVENT_CHECKSPAWN;

		LocalEvent thisEvent = localEvents.get(currentEventId);
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
		currentEventId = LocalEventId.LIVINGSPAWN_EVENT_SPECIALSPAWN;

		LocalEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * ZombieEvent is fired whenever a zombie is spawned for aid.
	 * 
	 */
	@SubscribeEvent
	public void zombieEvent(ZombieEvent event) {
		currentEventId = LocalEventId.ZOMBIE_EVENT;

		LocalEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

	/*
	 * SummonAidEvent is fired when a Zombie Entity is summoned.
	 * 
	 */
	@SubscribeEvent
	public void zombieEventSummonAidEvent(ZombieEvent.SummonAidEvent event) {
		currentEventId = LocalEventId.ZOMBIE_EVENT_SUMMONAID_EVENT;

		LocalEvent thisEvent = localEvents.get(currentEventId);
		thisEvent.logEvent(eventCounting, eventLogging);
		localEvents.put(currentEventId, thisEvent);
	}

}
