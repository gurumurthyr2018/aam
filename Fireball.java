/scoreboard objectives add fireball_tracker dummy Fireball Tracker

/scoreboard players set @e[type=minecraft:fireball] fireball_tracker 0

/execute as @a[scores={fireball_tracker=1..}] run data merge entity @s Pos[0,0,0] {HandItems:[{id:"minecraft:diamond_pickaxe",Count:1b,tag:{Unbreakable:1b}},{}]}
/execute as @a[scores={fireball_tracker=1..}] run data modify entity @s HandItems[0].tag.Unbreakable set value 0

/execute as @a run scoreboard players set @e[type=minecraft:fireball,distance=..4] fireball_tracker 1

/execute as @e[type=minecraft:fireball,score_fireball_tracker_min=1] run tp @e[type=!player,distance=..4] ~ ~2 ~
/execute as @e[type=minecraft:fireball,score_fireball_tracker_min=1] run damage @e[type=!player,distance=..4] 10
/execute as @e[type=minecraft:fireball,score_fireball_tracker_min=1] run summon minecraft:lightning_bolt
/execute as @e[type=minecraft:fireball,score_fireball_tracker_min=1] run scoreboard players set @e[type=minecraft:fireball] fireball_tracker 0
