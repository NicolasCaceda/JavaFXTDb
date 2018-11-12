/*
DROP TABLE secrets;
 */
DROP TABLE HunterSecrets;
DROP TABLE MageSecrets;
DROP TABLE PaladinSecrets;
DROP TABLE RogueSecrets;

CREATE TABLE secrets (
  secretName VARCHAR(19),
  manaCost INT NOT NULL,
  class VARCHAR(7),
  standard BOOLEAN,
  PRIMARY KEY (secretName)
);

CREATE TABLE HunterSecrets (
  secretName VARCHAR(19),
  standard BOOLEAN,
  PRIMARY KEY (secretName)
);

CREATE TABLE MageSecrets (
  secretName VARCHAR(19),
  standard BOOLEAN,
  PRIMARY KEY (secretName)
);

CREATE TABLE PaladinSecrets (
  secretName VARCHAR(19),
  standard BOOLEAN,
  PRIMARY KEY (secretName)
);

CREATE TABLE RogueSecrets (
  secretName VARCHAR(19),
  standard BOOLEAN,
  PRIMARY KEY (secretName)
);

INSERT INTO HunterSecrets(secretName, standard)
VALUES
       ('Explosive Trap',   true ),
       ('Freezing Trap',    true),
       ('Snipe',            true ),
       ('Misdirection',     true ),
       ('Venomstrike Trap', true ),
       ('Wandering Monster',true ),
       ('Rat Trap',         true ),
       ('Snake Trap',       true ),
       ('Dart Trap',        false ),
       ('Bear Trap',        false ),
       ('Cat Trick',        false ),
       ('Hidden Cache',     false )
;

INSERT INTO MageSecrets(secretName, standard)
VALUES
    ('Frozen Clone',       true ),
    ('Ice Barrier',        true ),
    ('Mirror Entity',      true ),
    ('Counterspell',       true ),
    ('Explosive Runes',    true ),
    ('Mana Bind',          true ),
    ('Vaporize',           true ),
    ('Spellbender',        true ),
    ('Duplicate',          false ),
    ('Effigy',             false ),
    ('Potion of Polymorph',false ),
    ('Ice Block',          false )
;

INSERT INTO PaladinSecrets(secretName, standard)
VALUES
       ('Autodefense Matrix', true ),
       ('Eye for an Eye',     true ),
       ('Noble Sacrifice',    true ),
       ('Redemption',         true ),
       ('Repentance',         true ),
       ('Hidden Wisdom',      true ),
       ('Avenge',             false ),
       ('Sacred Trial',       false ),
       ('Competitive Spirit', false ),
       ('Getaway Kodo',       false )
;

INSERT INTO RogueSecrets(secretName, standard)
VALUES
       ('Cheat Death',        false ),
       ('Sudden Betrayal',    false ),
       ('Evasion',            false )
;


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