DROP TABLE secrets;

CREATE TABLE secrets (
  secretName VARCHAR(19),
  manaCost INT NOT NULL,
  class VARCHAR(7),
  standard BOOLEAN,
  PRIMARY KEY (secretName)
);

INSERT INTO secrets(secretName, manaCost, class, standard)
VALUES
       ('Explosive Trap',     2, 'Hunter', true ),
       ('Freezing Trap',      2, 'Hunter', true),
       ('Snipe',              2, 'Hunter', true ),
       ('Misdirection',       2, 'Hunter', true ),
       ('Venomstrike Trap',   2, 'Hunter', true ),
       ('Wandering Monster',  2, 'Hunter', true ),
       ('Rat Trap',           2, 'Hunter', true ),
       ('Snake Trap',         2, 'Hunter', true ),
       ('Dart Trap',          2, 'Hunter', false ),
       ('Bear Trap',          2, 'Hunter', false ),
       ('Cat Trick',          2, 'Hunter', false ),
       ('Hidden Cache',       2, 'Hunter', false ),
       ('Frozen Clone',       3, 'Mage',   true ),
       ('Ice Barrier',        3, 'Mage',   true ),
       ('Mirror Entity',      3, 'Mage',   true ),
       ('Counterspell',       3, 'Mage',   true ),
       ('Explosive Runes',    3, 'Mage',   true ),
       ('Mana Bind',          3, 'Mage',   true ),
       ('Vaporize',           3, 'Mage',   true ),
       ('Spellbender',        3, 'Mage',   true ),
       ('Duplicate',          3, 'Mage',   false ),
       ('Effigy',             3, 'Mage',   false ),
       ('Potion of Polymorph',3, 'Mage',   false ),
       ('Ice Block',          3, 'Mage',   false ),
       ('Autodefense Matrix', 1, 'Paladin',true ),
       ('Eye for an Eye',     1, 'Paladin',true ),
       ('Noble Sacrifice',    1, 'Paladin',true ),
       ('Redemption',         1, 'Paladin',true ),
       ('Repentance',         1, 'Paladin',true ),
       ('Hidden Wisdom',      1, 'Paladin',true ),
       ('Avenge',             1, 'Paladin',false ),
       ('Sacred Trial',       1, 'Paladin',false ),
       ('Competitive Spirit', 1, 'Paladin',false ),
       ('Getaway Kodo',       1, 'Paladin',false ),
       ('Cheat Death',        2, 'Rogue',  false ),
       ('Sudden Betrayal',    2, 'Rogue',  false ),
       ('Evasion',            2, 'Rogue',  false )
;