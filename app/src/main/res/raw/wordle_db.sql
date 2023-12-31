CREATE TABLE IF NOT EXISTS "words" (
	"id"	INTEGER,
	"word"	TEXT,
	PRIMARY KEY("id" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "stats" (
	"id"	INTEGER,
	"games"	INTEGER,
	"wins"	INTEGER,
	"streak"	INTEGER,
	"max_streak"	INTEGER,
	PRIMARY KEY("id" AUTOINCREMENT)
);
INSERT INTO "words" ("id","word") VALUES
(1, 'aback'),
(2, 'abase'),
(3, 'abate'),
(4, 'abbey'),
(5, 'abbot'),
(6, 'abhor'),
(7, 'abide'),
(8, 'abled'),
(9, 'abode'),
(10, 'abort'),
(11, 'about'),
(12, 'above'),
(13, 'abuse'),
(14, 'abyss'),
(15, 'acorn'),
(16, 'acrid'),
(17, 'actor'),
(18, 'acute'),
(19, 'adage'),
(20, 'adapt'),
(21, 'adept'),
(22, 'admin'),
(23, 'admit'),
(24, 'adobe'),
(25, 'adopt'),
(26, 'adore'),
(27, 'adorn'),
(28, 'adult'),
(29, 'affix'),
(30, 'afire'),
(31, 'afoot'),
(32, 'afoul'),
(33, 'after'),
(34, 'again'),
(35, 'agape'),
(36, 'agate'),
(37, 'agent'),
(38, 'agile'),
(39, 'aging'),
(40, 'aglow'),
(41, 'agony'),
(42, 'agree'),
(43, 'ahead'),
(44, 'aider'),
(45, 'aisle'),
(46, 'alarm'),
(47, 'album'),
(48, 'alert'),
(49, 'algae'),
(50, 'alibi'),
(51, 'alien'),
(52, 'align'),
(53, 'alike'),
(54, 'alive'),
(55, 'allay'),
(56, 'alley'),
(57, 'allot'),
(58, 'allow'),
(59, 'alloy'),
(60, 'aloft'),
(61, 'alone'),
(62, 'along'),
(63, 'aloof'),
(64, 'aloud'),
(65, 'alpha'),
(66, 'altar'),
(67, 'alter'),
(68, 'amass'),
(69, 'amaze'),
(70, 'amber'),
(71, 'amble'),
(72, 'amend'),
(73, 'amiss'),
(74, 'amity'),
(75, 'among'),
(76, 'ample'),
(77, 'amply'),
(78, 'amuse'),
(79, 'angel'),
(80, 'anger'),
(81, 'angle'),
(82, 'angry'),
(83, 'angst'),
(84, 'anime'),
(85, 'ankle'),
(86, 'annex'),
(87, 'annoy'),
(88, 'annul'),
(89, 'anode'),
(90, 'antic'),
(91, 'anvil'),
(92, 'aorta'),
(93, 'apart'),
(94, 'aphid'),
(95, 'aping'),
(96, 'apnea'),
(97, 'apple'),
(98, 'apply'),
(99, 'apron'),
(100, 'aptly'),
(101, 'arbor'),
(102, 'ardor'),
(103, 'arena'),
(104, 'argue'),
(105, 'arise'),
(106, 'armor'),
(107, 'aroma'),
(108, 'arose'),
(109, 'array'),
(110, 'arrow'),
(111, 'arson'),
(112, 'artsy'),
(113, 'ascot'),
(114, 'ashen'),
(115, 'aside'),
(116, 'askew'),
(117, 'assay'),
(118, 'asset'),
(119, 'atoll'),
(120, 'atone'),
(121, 'attic'),
(122, 'audio'),
(123, 'audit'),
(124, 'augur'),
(125, 'aunty'),
(126, 'avail'),
(127, 'avert'),
(128, 'avian'),
(129, 'avoid'),
(130, 'await'),
(131, 'awake'),
(132, 'award'),
(133, 'aware'),
(134, 'awash'),
(135, 'awful'),
(136, 'awoke'),
(137, 'axial'),
(138, 'axiom'),
(139, 'axion'),
(140, 'azure'),
(141, 'bacon'),
(142, 'badge'),
(143, 'badly'),
(144, 'bagel'),
(145, 'baggy'),
(146, 'baker'),
(147, 'baler'),
(148, 'balmy'),
(149, 'banal'),
(150, 'banjo'),
(151, 'barge'),
(152, 'baron'),
(153, 'basal'),
(154, 'basic'),
(155, 'basil'),
(156, 'basin'),
(157, 'basis'),
(158, 'baste'),
(159, 'batch'),
(160, 'bathe'),
(161, 'baton'),
(162, 'batty'),
(163, 'bawdy'),
(164, 'bayou'),
(165, 'beach'),
(166, 'beady'),
(167, 'beard'),
(168, 'beast'),
(169, 'beech'),
(170, 'beefy'),
(171, 'befit'),
(172, 'began'),
(173, 'begat'),
(174, 'beget'),
(175, 'begin'),
(176, 'begun'),
(177, 'being'),
(178, 'belch'),
(179, 'belie'),
(180, 'belle'),
(181, 'belly'),
(182, 'below'),
(183, 'bench'),
(184, 'beret'),
(185, 'berry'),
(186, 'berth'),
(187, 'beset'),
(188, 'betel'),
(189, 'bevel'),
(190, 'bezel'),
(191, 'bible'),
(192, 'bicep'),
(193, 'biddy'),
(194, 'bigot'),
(195, 'bilge'),
(196, 'billy'),
(197, 'binge'),
(198, 'bingo'),
(199, 'biome'),
(200, 'birch'),
(201, 'birth'),
(202, 'bison'),
(203, 'bitty'),
(204, 'black'),
(205, 'blade'),
(206, 'blame'),
(207, 'bland'),
(208, 'blank'),
(209, 'blare'),
(210, 'blast'),
(211, 'blaze'),
(212, 'bleak'),
(213, 'bleat'),
(214, 'bleed'),
(215, 'bleep'),
(216, 'blend'),
(217, 'bless'),
(218, 'blimp'),
(219, 'blind'),
(220, 'blink'),
(221, 'bliss'),
(222, 'blitz'),
(223, 'bloat'),
(224, 'block'),
(225, 'bloke'),
(226, 'blond'),
(227, 'blood'),
(228, 'bloom'),
(229, 'blown'),
(230, 'bluer'),
(231, 'bluff'),
(232, 'blunt'),
(233, 'blurb'),
(234, 'blurt'),
(235, 'blush'),
(236, 'board'),
(237, 'boast'),
(238, 'bobby'),
(239, 'boney'),
(240, 'bongo'),
(241, 'bonus'),
(242, 'booby'),
(243, 'boost'),
(244, 'booth'),
(245, 'booty'),
(246, 'booze'),
(247, 'boozy'),
(248, 'borax'),
(249, 'borne'),
(250, 'bosom'),
(251, 'bossy'),
(252, 'botch'),
(253, 'bough'),
(254, 'boule'),
(255, 'bound'),
(256, 'bowel'),
(257, 'boxer'),
(258, 'brace'),
(259, 'braid'),
(260, 'brain'),
(261, 'brake'),
(262, 'brand'),
(263, 'brash'),
(264, 'brass'),
(265, 'brave'),
(266, 'bravo'),
(267, 'brawl'),
(268, 'brawn'),
(269, 'bread'),
(270, 'break'),
(271, 'breed'),
(272, 'briar'),
(273, 'bribe'),
(274, 'brick'),
(275, 'bride'),
(276, 'brief'),
(277, 'brine'),
(278, 'bring'),
(279, 'brink'),
(280, 'briny'),
(281, 'brisk'),
(282, 'broad'),
(283, 'broil'),
(284, 'broke'),
(285, 'brood'),
(286, 'brook'),
(287, 'broom'),
(288, 'broth'),
(289, 'brown'),
(290, 'brunt'),
(291, 'brush'),
(292, 'brute'),
(293, 'buddy'),
(294, 'budge'),
(295, 'buggy'),
(296, 'bugle'),
(297, 'build'),
(298, 'built'),
(299, 'bulge'),
(300, 'bulky'),
(301, 'bully'),
(302, 'bunch'),
(303, 'bunny'),
(304, 'burly'),
(305, 'burnt'),
(306, 'burst'),
(307, 'bused'),
(308, 'bushy'),
(309, 'butch'),
(310, 'butte'),
(311, 'buxom'),
(312, 'buyer'),
(313, 'bylaw'),
(314, 'cabal'),
(315, 'cabby'),
(316, 'cabin'),
(317, 'cable'),
(318, 'cacao'),
(319, 'cache'),
(320, 'cacti'),
(321, 'caddy'),
(322, 'cadet'),
(323, 'cagey'),
(324, 'cairn'),
(325, 'camel'),
(326, 'cameo'),
(327, 'canal'),
(328, 'candy'),
(329, 'canny'),
(330, 'canoe'),
(331, 'canon'),
(332, 'caper'),
(333, 'caput'),
(334, 'carat'),
(335, 'cargo'),
(336, 'carol'),
(337, 'carry'),
(338, 'carve'),
(339, 'caste'),
(340, 'catch'),
(341, 'cater'),
(342, 'catty'),
(343, 'caulk'),
(344, 'cause'),
(345, 'cavil'),
(346, 'cease'),
(347, 'cedar'),
(348, 'cello'),
(349, 'chafe'),
(350, 'chaff'),
(351, 'chain'),
(352, 'chair'),
(353, 'chalk'),
(354, 'champ'),
(355, 'chant'),
(356, 'chaos'),
(357, 'chard'),
(358, 'charm'),
(359, 'chart'),
(360, 'chase'),
(361, 'chasm'),
(362, 'cheap'),
(363, 'cheat'),
(364, 'check'),
(365, 'cheek'),
(366, 'cheer'),
(367, 'chess'),
(368, 'chest'),
(369, 'chick'),
(370, 'chide'),
(371, 'chief'),
(372, 'child'),
(373, 'chili'),
(374, 'chill'),
(375, 'chime'),
(376, 'china'),
(377, 'chirp'),
(378, 'chock'),
(379, 'choir'),
(380, 'choke'),
(381, 'chord'),
(382, 'chore'),
(383, 'chose'),
(384, 'chuck'),
(385, 'chump'),
(386, 'chunk'),
(387, 'churn'),
(388, 'chute'),
(389, 'cider'),
(390, 'cigar'),
(391, 'cinch'),
(392, 'circa'),
(393, 'civic'),
(394, 'civil'),
(395, 'clack'),
(396, 'claim'),
(397, 'clamp'),
(398, 'clang'),
(399, 'clank'),
(400, 'clash'),
(401, 'clasp'),
(402, 'class'),
(403, 'clean'),
(404, 'clear'),
(405, 'cleat'),
(406, 'cleft'),
(407, 'clerk'),
(408, 'click'),
(409, 'cliff'),
(410, 'climb'),
(411, 'cling'),
(412, 'clink'),
(413, 'cloak'),
(414, 'clock'),
(415, 'clone'),
(416, 'close'),
(417, 'cloth'),
(418, 'cloud'),
(419, 'clout'),
(420, 'clove'),
(421, 'clown'),
(422, 'cluck'),
(423, 'clued'),
(424, 'clump'),
(425, 'clung'),
(426, 'coach'),
(427, 'coast'),
(428, 'cobra'),
(429, 'cocoa'),
(430, 'colon'),
(431, 'color'),
(432, 'comet'),
(433, 'comfy'),
(434, 'comic'),
(435, 'comma'),
(436, 'conch'),
(437, 'condo'),
(438, 'conic'),
(439, 'copse'),
(440, 'coral'),
(441, 'corer'),
(442, 'corny'),
(443, 'couch'),
(444, 'cough'),
(445, 'could'),
(446, 'count'),
(447, 'coupe'),
(448, 'court'),
(449, 'coven'),
(450, 'cover'),
(451, 'covet'),
(452, 'covey'),
(453, 'cower'),
(454, 'coyly'),
(455, 'crack'),
(456, 'craft'),
(457, 'cramp'),
(458, 'crane'),
(459, 'crank'),
(460, 'crash'),
(461, 'crass'),
(462, 'crate'),
(463, 'crave'),
(464, 'crawl'),
(465, 'craze'),
(466, 'crazy'),
(467, 'creak'),
(468, 'cream'),
(469, 'credo'),
(470, 'creed'),
(471, 'creek'),
(472, 'creep'),
(473, 'creme'),
(474, 'crepe'),
(475, 'crept'),
(476, 'cress'),
(477, 'crest'),
(478, 'crick'),
(479, 'cried'),
(480, 'crier'),
(481, 'crime'),
(482, 'crimp'),
(483, 'crisp'),
(484, 'croak'),
(485, 'crock'),
(486, 'crone'),
(487, 'crony'),
(488, 'crook'),
(489, 'cross'),
(490, 'croup'),
(491, 'crowd'),
(492, 'crown'),
(493, 'crude'),
(494, 'cruel'),
(495, 'crumb'),
(496, 'crump'),
(497, 'crush'),
(498, 'crust'),
(499, 'crypt'),
(500, 'cubic'),
(501, 'cumin'),
(502, 'curio'),
(503, 'curly'),
(504, 'curry'),
(505, 'curse'),
(506, 'curve'),
(507, 'curvy'),
(508, 'cutie'),
(509, 'cyber'),
(510, 'cycle'),
(511, 'cynic'),
(512, 'daddy'),
(513, 'daily'),
(514, 'dairy'),
(515, 'daisy'),
(516, 'dally'),
(517, 'dance'),
(518, 'dandy'),
(519, 'datum'),
(520, 'daunt'),
(521, 'dealt'),
(522, 'death'),
(523, 'debar'),
(524, 'debit'),
(525, 'debug'),
(526, 'debut'),
(527, 'decal'),
(528, 'decay'),
(529, 'decor'),
(530, 'decoy'),
(531, 'decry'),
(532, 'defer'),
(533, 'deign'),
(534, 'deity'),
(535, 'delay'),
(536, 'delta'),
(537, 'delve'),
(538, 'demon'),
(539, 'demur'),
(540, 'denim'),
(541, 'dense'),
(542, 'depot'),
(543, 'depth'),
(544, 'derby'),
(545, 'deter'),
(546, 'detox'),
(547, 'deuce'),
(548, 'devil'),
(549, 'diary'),
(550, 'dicey'),
(551, 'digit'),
(552, 'dilly'),
(553, 'dimly'),
(554, 'diner'),
(555, 'dingo'),
(556, 'dingy'),
(557, 'diode'),
(558, 'dirge'),
(559, 'dirty'),
(560, 'disco'),
(561, 'ditch'),
(562, 'ditto'),
(563, 'ditty'),
(564, 'diver'),
(565, 'dizzy'),
(566, 'dodge'),
(567, 'dodgy'),
(568, 'dogma'),
(569, 'doing'),
(570, 'dolly'),
(571, 'donor'),
(572, 'donut'),
(573, 'dopey'),
(574, 'doubt'),
(575, 'dough'),
(576, 'dowdy'),
(577, 'dowel'),
(578, 'downy'),
(579, 'dowry'),
(580, 'dozen'),
(581, 'draft'),
(582, 'drain'),
(583, 'drake'),
(584, 'drama'),
(585, 'drank'),
(586, 'drape'),
(587, 'drawl'),
(588, 'drawn'),
(589, 'dread'),
(590, 'dream'),
(591, 'dress'),
(592, 'dried'),
(593, 'drier'),
(594, 'drift'),
(595, 'drill'),
(596, 'drink'),
(597, 'drive'),
(598, 'droit'),
(599, 'droll'),
(600, 'drone'),
(601, 'drool'),
(602, 'droop'),
(603, 'dross'),
(604, 'drove'),
(605, 'drown'),
(606, 'druid'),
(607, 'drunk'),
(608, 'dryer'),
(609, 'dryly'),
(610, 'duchy'),
(611, 'dully'),
(612, 'dummy'),
(613, 'dumpy'),
(614, 'dunce'),
(615, 'dusky'),
(616, 'dusty'),
(617, 'dutch'),
(618, 'duvet'),
(619, 'dwarf'),
(620, 'dwell'),
(621, 'dwelt'),
(622, 'dying'),
(623, 'eager'),
(624, 'eagle'),
(625, 'early'),
(626, 'earth'),
(627, 'easel'),
(628, 'eaten'),
(629, 'eater'),
(630, 'ebony'),
(631, 'eclat'),
(632, 'edict'),
(633, 'edify'),
(634, 'eerie'),
(635, 'egret'),
(636, 'eight'),
(637, 'eject'),
(638, 'eking'),
(639, 'elate'),
(640, 'elbow'),
(641, 'elder'),
(642, 'elect'),
(643, 'elegy'),
(644, 'elfin'),
(645, 'elide'),
(646, 'elite'),
(647, 'elope'),
(648, 'elude'),
(649, 'email'),
(650, 'embed'),
(651, 'ember'),
(652, 'emcee'),
(653, 'empty'),
(654, 'enact'),
(655, 'endow'),
(656, 'enema'),
(657, 'enemy'),
(658, 'enjoy'),
(659, 'ennui'),
(660, 'ensue'),
(661, 'enter'),
(662, 'entry'),
(663, 'envoy'),
(664, 'epoch'),
(665, 'epoxy'),
(666, 'equal'),
(667, 'equip'),
(668, 'erase'),
(669, 'erect'),
(670, 'erode'),
(671, 'error'),
(672, 'erupt'),
(673, 'essay'),
(674, 'ester'),
(675, 'ether'),
(676, 'ethic'),
(677, 'ethos'),
(678, 'etude'),
(679, 'evade'),
(680, 'event'),
(681, 'every'),
(682, 'evict'),
(683, 'evoke'),
(684, 'exact'),
(685, 'exalt'),
(686, 'excel'),
(687, 'exert'),
(688, 'exile'),
(689, 'exist'),
(690, 'expel'),
(691, 'extol'),
(692, 'extra'),
(693, 'exult'),
(694, 'eying'),
(695, 'fable'),
(696, 'facet'),
(697, 'faint'),
(698, 'fairy'),
(699, 'faith'),
(700, 'false'),
(701, 'fancy'),
(702, 'fanny'),
(703, 'farce'),
(704, 'fatal'),
(705, 'fatty'),
(706, 'fault'),
(707, 'fauna'),
(708, 'favor'),
(709, 'feast'),
(710, 'fecal'),
(711, 'feign'),
(712, 'fella'),
(713, 'felon'),
(714, 'femme'),
(715, 'femur'),
(716, 'fence'),
(717, 'feral'),
(718, 'ferry'),
(719, 'fetal'),
(720, 'fetch'),
(721, 'fetid'),
(722, 'fetus'),
(723, 'fever'),
(724, 'fewer'),
(725, 'fiber'),
(726, 'ficus'),
(727, 'field'),
(728, 'fiend'),
(729, 'fiery'),
(730, 'fifth'),
(731, 'fifty'),
(732, 'fight'),
(733, 'filer'),
(734, 'filet'),
(735, 'filly'),
(736, 'filmy'),
(737, 'filth'),
(738, 'final'),
(739, 'finch'),
(740, 'finer'),
(741, 'first'),
(742, 'fishy'),
(743, 'fixer'),
(744, 'fizzy'),
(745, 'fjord'),
(746, 'flack'),
(747, 'flail'),
(748, 'flair'),
(749, 'flake'),
(750, 'flaky'),
(751, 'flame'),
(752, 'flank'),
(753, 'flare'),
(754, 'flash'),
(755, 'flask'),
(756, 'fleck'),
(757, 'fleet'),
(758, 'flesh'),
(759, 'flick'),
(760, 'flier'),
(761, 'fling'),
(762, 'flint'),
(763, 'flirt'),
(764, 'float'),
(765, 'flock'),
(766, 'flood'),
(767, 'floor'),
(768, 'flora'),
(769, 'floss'),
(770, 'flour'),
(771, 'flout'),
(772, 'flown'),
(773, 'fluff'),
(774, 'fluid'),
(775, 'fluke'),
(776, 'flume'),
(777, 'flung'),
(778, 'flunk'),
(779, 'flush'),
(780, 'flute'),
(781, 'flyer'),
(782, 'foamy'),
(783, 'focal'),
(784, 'focus'),
(785, 'foggy'),
(786, 'foist'),
(787, 'folio'),
(788, 'folly'),
(789, 'foray'),
(790, 'force'),
(791, 'forge'),
(792, 'forgo'),
(793, 'forte'),
(794, 'forth'),
(795, 'forty'),
(796, 'forum'),
(797, 'found'),
(798, 'foyer'),
(799, 'frail'),
(800, 'frame'),
(801, 'frank'),
(802, 'fraud'),
(803, 'freak'),
(804, 'freed'),
(805, 'freer'),
(806, 'fresh'),
(807, 'friar'),
(808, 'fried'),
(809, 'frill'),
(810, 'frisk'),
(811, 'fritz'),
(812, 'frock'),
(813, 'frond'),
(814, 'front'),
(815, 'frost'),
(816, 'froth'),
(817, 'frown'),
(818, 'froze'),
(819, 'fruit'),
(820, 'fudge'),
(821, 'fugue'),
(822, 'fully'),
(823, 'fungi'),
(824, 'funky'),
(825, 'funny'),
(826, 'furor'),
(827, 'furry'),
(828, 'fussy'),
(829, 'fuzzy'),
(830, 'gaffe'),
(831, 'gaily'),
(832, 'gamer'),
(833, 'gamma'),
(834, 'gamut'),
(835, 'gassy'),
(836, 'gaudy'),
(837, 'gauge'),
(838, 'gaunt'),
(839, 'gauze'),
(840, 'gavel'),
(841, 'gawky'),
(842, 'gayer'),
(843, 'gayly'),
(844, 'gazer'),
(845, 'gecko'),
(846, 'geeky'),
(847, 'geese'),
(848, 'genie'),
(849, 'genre'),
(850, 'ghost'),
(851, 'ghoul'),
(852, 'giant'),
(853, 'giddy'),
(854, 'gipsy'),
(855, 'girly'),
(856, 'girth'),
(857, 'given'),
(858, 'giver'),
(859, 'glade'),
(860, 'gland'),
(861, 'glare'),
(862, 'glass'),
(863, 'glaze'),
(864, 'gleam'),
(865, 'glean'),
(866, 'glide'),
(867, 'glint'),
(868, 'gloat'),
(869, 'globe'),
(870, 'gloom'),
(871, 'glory'),
(872, 'gloss'),
(873, 'glove'),
(874, 'glyph'),
(875, 'gnash'),
(876, 'gnome'),
(877, 'godly'),
(878, 'going'),
(879, 'golem'),
(880, 'golly'),
(881, 'gonad'),
(882, 'goner'),
(883, 'goody'),
(884, 'gooey'),
(885, 'goofy'),
(886, 'goose'),
(887, 'gorge'),
(888, 'gouge'),
(889, 'gourd'),
(890, 'grace'),
(891, 'grade'),
(892, 'graft'),
(893, 'grail'),
(894, 'grain'),
(895, 'grand'),
(896, 'grant'),
(897, 'grape'),
(898, 'graph'),
(899, 'grasp'),
(900, 'grass'),
(901, 'grate'),
(902, 'grave'),
(903, 'gravy'),
(904, 'graze'),
(905, 'great'),
(906, 'greed'),
(907, 'green'),
(908, 'greet'),
(909, 'grief'),
(910, 'grill'),
(911, 'grime'),
(912, 'grimy'),
(913, 'grind'),
(914, 'gripe'),
(915, 'groan'),
(916, 'groin'),
(917, 'groom'),
(918, 'grope'),
(919, 'gross'),
(920, 'group'),
(921, 'grout'),
(922, 'grove'),
(923, 'growl'),
(924, 'grown'),
(925, 'gruel'),
(926, 'gruff'),
(927, 'grunt'),
(928, 'guard'),
(929, 'guava'),
(930, 'guess'),
(931, 'guest'),
(932, 'guide'),
(933, 'guild'),
(934, 'guile'),
(935, 'guilt'),
(936, 'guise'),
(937, 'gulch'),
(938, 'gully'),
(939, 'gumbo'),
(940, 'gummy'),
(941, 'guppy'),
(942, 'gusto'),
(943, 'gusty'),
(944, 'gypsy'),
(945, 'habit'),
(946, 'hairy'),
(947, 'halve'),
(948, 'handy'),
(949, 'happy'),
(950, 'hardy'),
(951, 'harem'),
(952, 'harpy'),
(953, 'harry'),
(954, 'harsh'),
(955, 'haste'),
(956, 'hasty'),
(957, 'hatch'),
(958, 'hater'),
(959, 'haunt'),
(960, 'haute'),
(961, 'haven'),
(962, 'havoc'),
(963, 'hazel'),
(964, 'heady'),
(965, 'heard'),
(966, 'heart'),
(967, 'heath'),
(968, 'heave'),
(969, 'heavy'),
(970, 'hedge'),
(971, 'hefty'),
(972, 'heist'),
(973, 'helix'),
(974, 'hello'),
(975, 'hence'),
(976, 'heron'),
(977, 'hilly'),
(978, 'hinge'),
(979, 'hippo'),
(980, 'hippy'),
(981, 'hitch'),
(982, 'hoard'),
(983, 'hobby'),
(984, 'hoist'),
(985, 'holly'),
(986, 'homer'),
(987, 'honey'),
(988, 'honor'),
(989, 'horde'),
(990, 'horny'),
(991, 'horse'),
(992, 'hotel'),
(993, 'hotly'),
(994, 'hound'),
(995, 'house'),
(996, 'hovel'),
(997, 'hover'),
(998, 'howdy'),
(999, 'human'),
(1000, 'humid'),
(1001, 'humor'),
(1002, 'humph'),
(1003, 'humus'),
(1004, 'hunch'),
(1005, 'hunky'),
(1006, 'hurry'),
(1007, 'husky'),
(1008, 'hussy'),
(1009, 'hutch'),
(1010, 'hydro'),
(1011, 'hyena'),
(1012, 'hymen'),
(1013, 'hyper'),
(1014, 'icily'),
(1015, 'icing'),
(1016, 'ideal'),
(1017, 'idiom'),
(1018, 'idiot'),
(1019, 'idler'),
(1020, 'idyll'),
(1021, 'igloo'),
(1022, 'iliac'),
(1023, 'image'),
(1024, 'imbue'),
(1025, 'impel'),
(1026, 'imply'),
(1027, 'inane'),
(1028, 'inbox'),
(1029, 'incur'),
(1030, 'index'),
(1031, 'inept'),
(1032, 'inert'),
(1033, 'infer'),
(1034, 'ingot'),
(1035, 'inlay'),
(1036, 'inlet'),
(1037, 'inner'),
(1038, 'input'),
(1039, 'inter'),
(1040, 'intro'),
(1041, 'ionic'),
(1042, 'irate'),
(1043, 'irony'),
(1044, 'islet'),
(1045, 'issue'),
(1046, 'itchy'),
(1047, 'ivory'),
(1048, 'jaunt'),
(1049, 'jazzy'),
(1050, 'jelly'),
(1051, 'jerky'),
(1052, 'jetty'),
(1053, 'jewel'),
(1054, 'jiffy'),
(1055, 'joint'),
(1056, 'joist'),
(1057, 'joker'),
(1058, 'jolly'),
(1059, 'joust'),
(1060, 'judge'),
(1061, 'juice'),
(1062, 'juicy'),
(1063, 'jumbo'),
(1064, 'jumpy'),
(1065, 'junta'),
(1066, 'junto'),
(1067, 'juror'),
(1068, 'kappa'),
(1069, 'karma'),
(1070, 'kayak'),
(1071, 'kebab'),
(1072, 'khaki'),
(1073, 'kinky'),
(1074, 'kiosk'),
(1075, 'kitty'),
(1076, 'knack'),
(1077, 'knave'),
(1078, 'knead'),
(1079, 'kneed'),
(1080, 'kneel'),
(1081, 'knelt'),
(1082, 'knife'),
(1083, 'knock'),
(1084, 'knoll'),
(1085, 'known'),
(1086, 'koala'),
(1087, 'krill'),
(1088, 'label'),
(1089, 'labor'),
(1090, 'laden'),
(1091, 'ladle'),
(1092, 'lager'),
(1093, 'lance'),
(1094, 'lanky'),
(1095, 'lapel'),
(1096, 'lapse'),
(1097, 'large'),
(1098, 'larva'),
(1099, 'lasso'),
(1100, 'latch'),
(1101, 'later'),
(1102, 'lathe'),
(1103, 'latte'),
(1104, 'laugh'),
(1105, 'layer'),
(1106, 'leach'),
(1107, 'leafy'),
(1108, 'leaky'),
(1109, 'leant'),
(1110, 'leapt'),
(1111, 'learn'),
(1112, 'lease'),
(1113, 'leash'),
(1114, 'least'),
(1115, 'leave'),
(1116, 'ledge'),
(1117, 'leech'),
(1118, 'leery'),
(1119, 'lefty'),
(1120, 'legal'),
(1121, 'leggy'),
(1122, 'lemon'),
(1123, 'lemur'),
(1124, 'leper'),
(1125, 'level'),
(1126, 'lever'),
(1127, 'libel'),
(1128, 'liege'),
(1129, 'light'),
(1130, 'liken'),
(1131, 'lilac'),
(1132, 'limbo'),
(1133, 'limit'),
(1134, 'linen'),
(1135, 'liner'),
(1136, 'lingo'),
(1137, 'lipid'),
(1138, 'lithe'),
(1139, 'liver'),
(1140, 'livid'),
(1141, 'llama'),
(1142, 'loamy'),
(1143, 'loath'),
(1144, 'lobby'),
(1145, 'local'),
(1146, 'locus'),
(1147, 'lodge'),
(1148, 'lofty'),
(1149, 'logic'),
(1150, 'login'),
(1151, 'loopy'),
(1152, 'loose'),
(1153, 'lorry'),
(1154, 'loser'),
(1155, 'louse'),
(1156, 'lousy'),
(1157, 'lover'),
(1158, 'lower'),
(1159, 'lowly'),
(1160, 'loyal'),
(1161, 'lucid'),
(1162, 'lucky'),
(1163, 'lumen'),
(1164, 'lumpy'),
(1165, 'lunar'),
(1166, 'lunch'),
(1167, 'lunge'),
(1168, 'lupus'),
(1169, 'lurch'),
(1170, 'lurid'),
(1171, 'lusty'),
(1172, 'lying'),
(1173, 'lymph'),
(1174, 'lyric'),
(1175, 'macaw'),
(1176, 'macho'),
(1177, 'macro'),
(1178, 'madam'),
(1179, 'madly'),
(1180, 'mafia'),
(1181, 'magic'),
(1182, 'magma'),
(1183, 'maize'),
(1184, 'major'),
(1185, 'maker'),
(1186, 'mambo'),
(1187, 'mamma'),
(1188, 'mammy'),
(1189, 'manga'),
(1190, 'mange'),
(1191, 'mango'),
(1192, 'mangy'),
(1193, 'mania'),
(1194, 'manic'),
(1195, 'manly'),
(1196, 'manor'),
(1197, 'maple'),
(1198, 'march'),
(1199, 'marry'),
(1200, 'marsh'),
(1201, 'mason'),
(1202, 'masse'),
(1203, 'match'),
(1204, 'matey'),
(1205, 'mauve'),
(1206, 'maxim'),
(1207, 'maybe'),
(1208, 'mayor'),
(1209, 'mealy'),
(1210, 'meant'),
(1211, 'meaty'),
(1212, 'mecca'),
(1213, 'medal'),
(1214, 'media'),
(1215, 'medic'),
(1216, 'melee'),
(1217, 'melon'),
(1218, 'mercy'),
(1219, 'merge'),
(1220, 'merit'),
(1221, 'merry'),
(1222, 'metal'),
(1223, 'meter'),
(1224, 'metro'),
(1225, 'micro'),
(1226, 'midge'),
(1227, 'midst'),
(1228, 'might'),
(1229, 'milky'),
(1230, 'mimic'),
(1231, 'mince'),
(1232, 'miner'),
(1233, 'minim'),
(1234, 'minor'),
(1235, 'minty'),
(1236, 'minus'),
(1237, 'mirth'),
(1238, 'miser'),
(1239, 'missy'),
(1240, 'mocha'),
(1241, 'modal'),
(1242, 'model'),
(1243, 'modem'),
(1244, 'mogul'),
(1245, 'moist'),
(1246, 'molar'),
(1247, 'moldy'),
(1248, 'money'),
(1249, 'month'),
(1250, 'moody'),
(1251, 'moose'),
(1252, 'moral'),
(1253, 'moron'),
(1254, 'morph'),
(1255, 'mossy'),
(1256, 'motel'),
(1257, 'motif'),
(1258, 'motor'),
(1259, 'motto'),
(1260, 'moult'),
(1261, 'mound'),
(1262, 'mount'),
(1263, 'mourn'),
(1264, 'mouse'),
(1265, 'mouth'),
(1266, 'mover'),
(1267, 'movie'),
(1268, 'mower'),
(1269, 'mucky'),
(1270, 'mucus'),
(1271, 'muddy'),
(1272, 'mulch'),
(1273, 'mummy'),
(1274, 'munch'),
(1275, 'mural'),
(1276, 'murky'),
(1277, 'mushy'),
(1278, 'music'),
(1279, 'musky'),
(1280, 'musty'),
(1281, 'myrrh'),
(1282, 'nadir'),
(1283, 'naive'),
(1284, 'nanny'),
(1285, 'nasal'),
(1286, 'nasty'),
(1287, 'natal'),
(1288, 'naval'),
(1289, 'navel'),
(1290, 'needy'),
(1291, 'neigh'),
(1292, 'nerdy'),
(1293, 'nerve'),
(1294, 'never'),
(1295, 'newer'),
(1296, 'newly'),
(1297, 'nicer'),
(1298, 'niche'),
(1299, 'niece'),
(1300, 'night'),
(1301, 'ninja'),
(1302, 'ninny'),
(1303, 'ninth'),
(1304, 'noble'),
(1305, 'nobly'),
(1306, 'noise'),
(1307, 'noisy'),
(1308, 'nomad'),
(1309, 'noose'),
(1310, 'north'),
(1311, 'nosey'),
(1312, 'notch'),
(1313, 'novel'),
(1314, 'nudge'),
(1315, 'nurse'),
(1316, 'nutty'),
(1317, 'nylon'),
(1318, 'nymph'),
(1319, 'oaken'),
(1320, 'obese'),
(1321, 'occur'),
(1322, 'ocean'),
(1323, 'octal'),
(1324, 'octet'),
(1325, 'odder'),
(1326, 'oddly'),
(1327, 'offal'),
(1328, 'offer'),
(1329, 'often'),
(1330, 'olden'),
(1331, 'older'),
(1332, 'olive'),
(1333, 'ombre'),
(1334, 'omega'),
(1335, 'onion'),
(1336, 'onset'),
(1337, 'opera'),
(1338, 'opine'),
(1339, 'opium'),
(1340, 'optic'),
(1341, 'orbit'),
(1342, 'order'),
(1343, 'organ'),
(1344, 'other'),
(1345, 'otter'),
(1346, 'ought'),
(1347, 'ounce'),
(1348, 'outdo'),
(1349, 'outer'),
(1350, 'outgo'),
(1351, 'ovary'),
(1352, 'ovate'),
(1353, 'overt'),
(1354, 'ovine'),
(1355, 'ovoid'),
(1356, 'owing'),
(1357, 'owner'),
(1358, 'oxide'),
(1359, 'ozone'),
(1360, 'paddy'),
(1361, 'pagan'),
(1362, 'paint'),
(1363, 'paler'),
(1364, 'palsy'),
(1365, 'panel'),
(1366, 'panic'),
(1367, 'pansy'),
(1368, 'papal'),
(1369, 'paper'),
(1370, 'parer'),
(1371, 'parka'),
(1372, 'parry'),
(1373, 'parse'),
(1374, 'party'),
(1375, 'pasta'),
(1376, 'paste'),
(1377, 'pasty'),
(1378, 'patch'),
(1379, 'patio'),
(1380, 'patsy'),
(1381, 'patty'),
(1382, 'pause'),
(1383, 'payee'),
(1384, 'payer'),
(1385, 'peace'),
(1386, 'peach'),
(1387, 'pearl'),
(1388, 'pecan'),
(1389, 'pedal'),
(1390, 'penal'),
(1391, 'pence'),
(1392, 'penne'),
(1393, 'penny'),
(1394, 'perch'),
(1395, 'peril'),
(1396, 'perky'),
(1397, 'pesky'),
(1398, 'pesto'),
(1399, 'petal'),
(1400, 'petty'),
(1401, 'phase'),
(1402, 'phone'),
(1403, 'phony'),
(1404, 'photo'),
(1405, 'piano'),
(1406, 'picky'),
(1407, 'piece'),
(1408, 'piety'),
(1409, 'piggy'),
(1410, 'pilot'),
(1411, 'pinch'),
(1412, 'piney'),
(1413, 'pinky'),
(1414, 'pinto'),
(1415, 'piper'),
(1416, 'pique'),
(1417, 'pitch'),
(1418, 'pithy'),
(1419, 'pivot'),
(1420, 'pixel'),
(1421, 'pixie'),
(1422, 'pizza'),
(1423, 'place'),
(1424, 'plaid'),
(1425, 'plain'),
(1426, 'plait'),
(1427, 'plane'),
(1428, 'plank'),
(1429, 'plant'),
(1430, 'plate'),
(1431, 'plaza'),
(1432, 'plead'),
(1433, 'pleat'),
(1434, 'plied'),
(1435, 'plier'),
(1436, 'pluck'),
(1437, 'plumb'),
(1438, 'plume'),
(1439, 'plump'),
(1440, 'plunk'),
(1441, 'plush'),
(1442, 'poesy'),
(1443, 'point'),
(1444, 'poise'),
(1445, 'poker'),
(1446, 'polar'),
(1447, 'polka'),
(1448, 'polyp'),
(1449, 'pooch'),
(1450, 'poppy'),
(1451, 'porch'),
(1452, 'poser'),
(1453, 'posit'),
(1454, 'posse'),
(1455, 'pouch'),
(1456, 'pound'),
(1457, 'pouty'),
(1458, 'power'),
(1459, 'prank'),
(1460, 'prawn'),
(1461, 'preen'),
(1462, 'press'),
(1463, 'price'),
(1464, 'prick'),
(1465, 'pride'),
(1466, 'pried'),
(1467, 'prime'),
(1468, 'primo'),
(1469, 'print'),
(1470, 'prior'),
(1471, 'prism'),
(1472, 'privy'),
(1473, 'prize'),
(1474, 'probe'),
(1475, 'prone'),
(1476, 'prong'),
(1477, 'proof'),
(1478, 'prose'),
(1479, 'proud'),
(1480, 'prove'),
(1481, 'prowl'),
(1482, 'proxy'),
(1483, 'prude'),
(1484, 'prune'),
(1485, 'psalm'),
(1486, 'pubic'),
(1487, 'pudgy'),
(1488, 'puffy'),
(1489, 'pulpy'),
(1490, 'pulse'),
(1491, 'punch'),
(1492, 'pupil'),
(1493, 'puppy'),
(1494, 'puree'),
(1495, 'purer'),
(1496, 'purge'),
(1497, 'purse'),
(1498, 'pushy'),
(1499, 'putty'),
(1500, 'pygmy'),
(1501, 'quack'),
(1502, 'quail'),
(1503, 'quake'),
(1504, 'qualm'),
(1505, 'quark'),
(1506, 'quart'),
(1507, 'quash'),
(1508, 'quasi'),
(1509, 'queen'),
(1510, 'queer'),
(1511, 'quell'),
(1512, 'query'),
(1513, 'quest'),
(1514, 'queue'),
(1515, 'quick'),
(1516, 'quiet'),
(1517, 'quill'),
(1518, 'quilt'),
(1519, 'quirk'),
(1520, 'quite'),
(1521, 'quota'),
(1522, 'quote'),
(1523, 'quoth'),
(1524, 'rabbi'),
(1525, 'rabid'),
(1526, 'racer'),
(1527, 'radar'),
(1528, 'radii'),
(1529, 'radio'),
(1530, 'rainy'),
(1531, 'raise'),
(1532, 'rajah'),
(1533, 'rally'),
(1534, 'ralph'),
(1535, 'ramen'),
(1536, 'ranch'),
(1537, 'randy'),
(1538, 'range'),
(1539, 'rapid'),
(1540, 'rarer'),
(1541, 'raspy'),
(1542, 'ratio'),
(1543, 'ratty'),
(1544, 'raven'),
(1545, 'rayon'),
(1546, 'razor'),
(1547, 'reach'),
(1548, 'react'),
(1549, 'ready'),
(1550, 'realm'),
(1551, 'rearm'),
(1552, 'rebar'),
(1553, 'rebel'),
(1554, 'rebus'),
(1555, 'rebut'),
(1556, 'recap'),
(1557, 'recur'),
(1558, 'recut'),
(1559, 'reedy'),
(1560, 'refer'),
(1561, 'refit'),
(1562, 'regal'),
(1563, 'rehab'),
(1564, 'reign'),
(1565, 'relax'),
(1566, 'relay'),
(1567, 'relic'),
(1568, 'remit'),
(1569, 'renal'),
(1570, 'renew'),
(1571, 'repay'),
(1572, 'repel'),
(1573, 'reply'),
(1574, 'rerun'),
(1575, 'reset'),
(1576, 'resin'),
(1577, 'retch'),
(1578, 'retro'),
(1579, 'retry'),
(1580, 'reuse'),
(1581, 'revel'),
(1582, 'revue'),
(1583, 'rhino'),
(1584, 'rhyme'),
(1585, 'rider'),
(1586, 'ridge'),
(1587, 'rifle'),
(1588, 'right'),
(1589, 'rigid'),
(1590, 'rigor'),
(1591, 'rinse'),
(1592, 'ripen'),
(1593, 'riper'),
(1594, 'risen'),
(1595, 'riser'),
(1596, 'risky'),
(1597, 'rival'),
(1598, 'river'),
(1599, 'rivet'),
(1600, 'roach'),
(1601, 'roast'),
(1602, 'robin'),
(1603, 'robot'),
(1604, 'rocky'),
(1605, 'rodeo'),
(1606, 'roger'),
(1607, 'rogue'),
(1608, 'roomy'),
(1609, 'roost'),
(1610, 'rotor'),
(1611, 'rouge'),
(1612, 'rough'),
(1613, 'round'),
(1614, 'rouse'),
(1615, 'route'),
(1616, 'rover'),
(1617, 'rowdy'),
(1618, 'rower'),
(1619, 'royal'),
(1620, 'ruddy'),
(1621, 'ruder'),
(1622, 'rugby'),
(1623, 'ruler'),
(1624, 'rumba'),
(1625, 'rumor'),
(1626, 'rupee'),
(1627, 'rural'),
(1628, 'rusty'),
(1629, 'sadly'),
(1630, 'safer'),
(1631, 'saint'),
(1632, 'salad'),
(1633, 'sally'),
(1634, 'salon'),
(1635, 'salsa'),
(1636, 'salty'),
(1637, 'salve'),
(1638, 'salvo'),
(1639, 'sandy'),
(1640, 'saner'),
(1641, 'sappy'),
(1642, 'sassy'),
(1643, 'satin'),
(1644, 'satyr'),
(1645, 'sauce'),
(1646, 'saucy'),
(1647, 'sauna'),
(1648, 'saute'),
(1649, 'savor'),
(1650, 'savoy'),
(1651, 'savvy'),
(1652, 'scald'),
(1653, 'scale'),
(1654, 'scalp'),
(1655, 'scaly'),
(1656, 'scamp'),
(1657, 'scant'),
(1658, 'scare'),
(1659, 'scarf'),
(1660, 'scary'),
(1661, 'scene'),
(1662, 'scent'),
(1663, 'scion'),
(1664, 'scoff'),
(1665, 'scold'),
(1666, 'scone'),
(1667, 'scoop'),
(1668, 'scope'),
(1669, 'score'),
(1670, 'scorn'),
(1671, 'scour'),
(1672, 'scout'),
(1673, 'scowl'),
(1674, 'scram'),
(1675, 'scrap'),
(1676, 'scree'),
(1677, 'screw'),
(1678, 'scrub'),
(1679, 'scrum'),
(1680, 'scuba'),
(1681, 'sedan'),
(1682, 'seedy'),
(1683, 'segue'),
(1684, 'seize'),
(1685, 'semen'),
(1686, 'sense'),
(1687, 'sepia'),
(1688, 'serif'),
(1689, 'serum'),
(1690, 'serve'),
(1691, 'setup'),
(1692, 'seven'),
(1693, 'sever'),
(1694, 'sewer'),
(1695, 'shack'),
(1696, 'shade'),
(1697, 'shady'),
(1698, 'shaft'),
(1699, 'shake'),
(1700, 'shaky'),
(1701, 'shale'),
(1702, 'shall'),
(1703, 'shalt'),
(1704, 'shame'),
(1705, 'shank'),
(1706, 'shape'),
(1707, 'shard'),
(1708, 'share'),
(1709, 'shark'),
(1710, 'sharp'),
(1711, 'shave'),
(1712, 'shawl'),
(1713, 'shear'),
(1714, 'sheen'),
(1715, 'sheep'),
(1716, 'sheer'),
(1717, 'sheet'),
(1718, 'sheik'),
(1719, 'shelf'),
(1720, 'shell'),
(1721, 'shied'),
(1722, 'shift'),
(1723, 'shine'),
(1724, 'shiny'),
(1725, 'shire'),
(1726, 'shirk'),
(1727, 'shirt'),
(1728, 'shoal'),
(1729, 'shock'),
(1730, 'shone'),
(1731, 'shook'),
(1732, 'shoot'),
(1733, 'shore'),
(1734, 'shorn'),
(1735, 'short'),
(1736, 'shout'),
(1737, 'shove'),
(1738, 'shown'),
(1739, 'showy'),
(1740, 'shrew'),
(1741, 'shrub'),
(1742, 'shrug'),
(1743, 'shuck'),
(1744, 'shunt'),
(1745, 'shush'),
(1746, 'shyly'),
(1747, 'siege'),
(1748, 'sieve'),
(1749, 'sight'),
(1750, 'sigma'),
(1751, 'silky'),
(1752, 'silly'),
(1753, 'since'),
(1754, 'sinew'),
(1755, 'singe'),
(1756, 'siren'),
(1757, 'sissy'),
(1758, 'sixth'),
(1759, 'sixty'),
(1760, 'skate'),
(1761, 'skier'),
(1762, 'skiff'),
(1763, 'skill'),
(1764, 'skimp'),
(1765, 'skirt'),
(1766, 'skulk'),
(1767, 'skull'),
(1768, 'skunk'),
(1769, 'slack'),
(1770, 'slain'),
(1771, 'slang'),
(1772, 'slant'),
(1773, 'slash'),
(1774, 'slate'),
(1775, 'sleek'),
(1776, 'sleep'),
(1777, 'sleet'),
(1778, 'slept'),
(1779, 'slice'),
(1780, 'slick'),
(1781, 'slide'),
(1782, 'slime'),
(1783, 'slimy'),
(1784, 'sling'),
(1785, 'slink'),
(1786, 'sloop'),
(1787, 'slope'),
(1788, 'slosh'),
(1789, 'sloth'),
(1790, 'slump'),
(1791, 'slung'),
(1792, 'slunk'),
(1793, 'slurp'),
(1794, 'slush'),
(1795, 'slyly'),
(1796, 'smack'),
(1797, 'small'),
(1798, 'smart'),
(1799, 'smash'),
(1800, 'smear'),
(1801, 'smell'),
(1802, 'smelt'),
(1803, 'smile'),
(1804, 'smirk'),
(1805, 'smite'),
(1806, 'smith'),
(1807, 'smock'),
(1808, 'smoke'),
(1809, 'smoky'),
(1810, 'smote'),
(1811, 'snack'),
(1812, 'snail'),
(1813, 'snake'),
(1814, 'snaky'),
(1815, 'snare'),
(1816, 'snarl'),
(1817, 'sneak'),
(1818, 'sneer'),
(1819, 'snide'),
(1820, 'sniff'),
(1821, 'snipe'),
(1822, 'snoop'),
(1823, 'snore'),
(1824, 'snort'),
(1825, 'snout'),
(1826, 'snowy'),
(1827, 'snuck'),
(1828, 'snuff'),
(1829, 'soapy'),
(1830, 'sober'),
(1831, 'soggy'),
(1832, 'solar'),
(1833, 'solid'),
(1834, 'solve'),
(1835, 'sonar'),
(1836, 'sonic'),
(1837, 'sooth'),
(1838, 'sooty'),
(1839, 'sorry'),
(1840, 'sound'),
(1841, 'south'),
(1842, 'sower'),
(1843, 'space'),
(1844, 'spade'),
(1845, 'spank'),
(1846, 'spare'),
(1847, 'spark'),
(1848, 'spasm'),
(1849, 'spawn'),
(1850, 'speak'),
(1851, 'spear'),
(1852, 'speck'),
(1853, 'speed'),
(1854, 'spell'),
(1855, 'spelt'),
(1856, 'spend'),
(1857, 'spent'),
(1858, 'sperm'),
(1859, 'spice'),
(1860, 'spicy'),
(1861, 'spied'),
(1862, 'spiel'),
(1863, 'spike'),
(1864, 'spiky'),
(1865, 'spill'),
(1866, 'spilt'),
(1867, 'spine'),
(1868, 'spiny'),
(1869, 'spire'),
(1870, 'spite'),
(1871, 'splat'),
(1872, 'split'),
(1873, 'spoil'),
(1874, 'spoke'),
(1875, 'spoof'),
(1876, 'spook'),
(1877, 'spool'),
(1878, 'spoon'),
(1879, 'spore'),
(1880, 'sport'),
(1881, 'spout'),
(1882, 'spray'),
(1883, 'spree'),
(1884, 'sprig'),
(1885, 'spunk'),
(1886, 'spurn'),
(1887, 'spurt'),
(1888, 'squad'),
(1889, 'squat'),
(1890, 'squib'),
(1891, 'stack'),
(1892, 'staff'),
(1893, 'stage'),
(1894, 'staid'),
(1895, 'stain'),
(1896, 'stair'),
(1897, 'stake'),
(1898, 'stale'),
(1899, 'stalk'),
(1900, 'stall'),
(1901, 'stamp'),
(1902, 'stand'),
(1903, 'stank'),
(1904, 'stare'),
(1905, 'stark'),
(1906, 'start'),
(1907, 'stash'),
(1908, 'state'),
(1909, 'stave'),
(1910, 'stead'),
(1911, 'steak'),
(1912, 'steal'),
(1913, 'steam'),
(1914, 'steed'),
(1915, 'steel'),
(1916, 'steep'),
(1917, 'steer'),
(1918, 'stein'),
(1919, 'stern'),
(1920, 'stick'),
(1921, 'stiff'),
(1922, 'still'),
(1923, 'stilt'),
(1924, 'sting'),
(1925, 'stink'),
(1926, 'stint'),
(1927, 'stock'),
(1928, 'stoic'),
(1929, 'stoke'),
(1930, 'stole'),
(1931, 'stomp'),
(1932, 'stone'),
(1933, 'stony'),
(1934, 'stood'),
(1935, 'stool'),
(1936, 'stoop'),
(1937, 'store'),
(1938, 'stork'),
(1939, 'storm'),
(1940, 'story'),
(1941, 'stout'),
(1942, 'stove'),
(1943, 'strap'),
(1944, 'straw'),
(1945, 'stray'),
(1946, 'strip'),
(1947, 'strut'),
(1948, 'stuck'),
(1949, 'study'),
(1950, 'stuff'),
(1951, 'stump'),
(1952, 'stung'),
(1953, 'stunk'),
(1954, 'stunt'),
(1955, 'style'),
(1956, 'suave'),
(1957, 'sugar'),
(1958, 'suing'),
(1959, 'suite'),
(1960, 'sulky'),
(1961, 'sully'),
(1962, 'sumac'),
(1963, 'sunny'),
(1964, 'super'),
(1965, 'surer'),
(1966, 'surge'),
(1967, 'surly'),
(1968, 'sushi'),
(1969, 'swami'),
(1970, 'swamp'),
(1971, 'swarm'),
(1972, 'swash'),
(1973, 'swath'),
(1974, 'swear'),
(1975, 'sweat'),
(1976, 'sweep'),
(1977, 'sweet'),
(1978, 'swell'),
(1979, 'swept'),
(1980, 'swift'),
(1981, 'swill'),
(1982, 'swine'),
(1983, 'swing'),
(1984, 'swirl'),
(1985, 'swish'),
(1986, 'swoon'),
(1987, 'swoop'),
(1988, 'sword'),
(1989, 'swore'),
(1990, 'sworn'),
(1991, 'swung'),
(1992, 'synod'),
(1993, 'syrup'),
(1994, 'tabby'),
(1995, 'table'),
(1996, 'taboo'),
(1997, 'tacit'),
(1998, 'tacky'),
(1999, 'taffy'),
(2000, 'taint'),
(2001, 'taken'),
(2002, 'taker'),
(2003, 'tally'),
(2004, 'talon'),
(2005, 'tamer'),
(2006, 'tango'),
(2007, 'tangy'),
(2008, 'taper'),
(2009, 'tapir'),
(2010, 'tardy'),
(2011, 'tarot'),
(2012, 'taste'),
(2013, 'tasty'),
(2014, 'tatty'),
(2015, 'taunt'),
(2016, 'tawny'),
(2017, 'teach'),
(2018, 'teary'),
(2019, 'tease'),
(2020, 'teddy'),
(2021, 'teeth'),
(2022, 'tempo'),
(2023, 'tenet'),
(2024, 'tenor'),
(2025, 'tense'),
(2026, 'tenth'),
(2027, 'tepee'),
(2028, 'tepid'),
(2029, 'terra'),
(2030, 'terse'),
(2031, 'testy'),
(2032, 'thank'),
(2033, 'theft'),
(2034, 'their'),
(2035, 'theme'),
(2036, 'there'),
(2037, 'these'),
(2038, 'theta'),
(2039, 'thick'),
(2040, 'thief'),
(2041, 'thigh'),
(2042, 'thing'),
(2043, 'think'),
(2044, 'third'),
(2045, 'thong'),
(2046, 'thorn'),
(2047, 'those'),
(2048, 'three'),
(2049, 'threw'),
(2050, 'throb'),
(2051, 'throw'),
(2052, 'thrum'),
(2053, 'thumb'),
(2054, 'thump'),
(2055, 'thyme'),
(2056, 'tiara'),
(2057, 'tibia'),
(2058, 'tidal'),
(2059, 'tiger'),
(2060, 'tight'),
(2061, 'tilde'),
(2062, 'timer'),
(2063, 'timid'),
(2064, 'tipsy'),
(2065, 'titan'),
(2066, 'tithe'),
(2067, 'title'),
(2068, 'toast'),
(2069, 'today'),
(2070, 'toddy'),
(2071, 'token'),
(2072, 'tonal'),
(2073, 'tonga'),
(2074, 'tonic'),
(2075, 'tooth'),
(2076, 'topaz'),
(2077, 'topic'),
(2078, 'torch'),
(2079, 'torso'),
(2080, 'torus'),
(2081, 'total'),
(2082, 'totem'),
(2083, 'touch'),
(2084, 'tough'),
(2085, 'towel'),
(2086, 'tower'),
(2087, 'toxic'),
(2088, 'toxin'),
(2089, 'trace'),
(2090, 'track'),
(2091, 'tract'),
(2092, 'trade'),
(2093, 'trail'),
(2094, 'train'),
(2095, 'trait'),
(2096, 'tramp'),
(2097, 'trash'),
(2098, 'trawl'),
(2099, 'tread'),
(2100, 'treat'),
(2101, 'trend'),
(2102, 'triad'),
(2103, 'trial'),
(2104, 'tribe'),
(2105, 'trice'),
(2106, 'trick'),
(2107, 'tried'),
(2108, 'tripe'),
(2109, 'trite'),
(2110, 'troll'),
(2111, 'troop'),
(2112, 'trope'),
(2113, 'trout'),
(2114, 'trove'),
(2115, 'truce'),
(2116, 'truck'),
(2117, 'truer'),
(2118, 'truly'),
(2119, 'trump'),
(2120, 'trunk'),
(2121, 'truss'),
(2122, 'trust'),
(2123, 'truth'),
(2124, 'tryst'),
(2125, 'tubal'),
(2126, 'tuber'),
(2127, 'tulip'),
(2128, 'tulle'),
(2129, 'tumor'),
(2130, 'tunic'),
(2131, 'turbo'),
(2132, 'tutor'),
(2133, 'twang'),
(2134, 'tweak'),
(2135, 'tweed'),
(2136, 'tweet'),
(2137, 'twice'),
(2138, 'twine'),
(2139, 'twirl'),
(2140, 'twist'),
(2141, 'twixt'),
(2142, 'tying'),
(2143, 'udder'),
(2144, 'ulcer'),
(2145, 'ultra'),
(2146, 'umbra'),
(2147, 'uncle'),
(2148, 'uncut'),
(2149, 'under'),
(2150, 'undid'),
(2151, 'undue'),
(2152, 'unfed'),
(2153, 'unfit'),
(2154, 'unify'),
(2155, 'union'),
(2156, 'unite'),
(2157, 'unity'),
(2158, 'unlit'),
(2159, 'unmet'),
(2160, 'unset'),
(2161, 'untie'),
(2162, 'until'),
(2163, 'unwed'),
(2164, 'unzip'),
(2165, 'upper'),
(2166, 'upset'),
(2167, 'urban'),
(2168, 'urine'),
(2169, 'usage'),
(2170, 'usher'),
(2171, 'using'),
(2172, 'usual'),
(2173, 'usurp'),
(2174, 'utile'),
(2175, 'utter'),
(2176, 'vague'),
(2177, 'valet'),
(2178, 'valid'),
(2179, 'valor'),
(2180, 'value'),
(2181, 'valve'),
(2182, 'vapid'),
(2183, 'vapor'),
(2184, 'vault'),
(2185, 'vaunt'),
(2186, 'vegan'),
(2187, 'venom'),
(2188, 'venue'),
(2189, 'verge'),
(2190, 'verse'),
(2191, 'verso'),
(2192, 'verve'),
(2193, 'vicar'),
(2194, 'video'),
(2195, 'vigil'),
(2196, 'vigor'),
(2197, 'villa'),
(2198, 'vinyl'),
(2199, 'viola'),
(2200, 'viper'),
(2201, 'viral'),
(2202, 'virus'),
(2203, 'visit'),
(2204, 'visor'),
(2205, 'vista'),
(2206, 'vital'),
(2207, 'vivid'),
(2208, 'vixen'),
(2209, 'vocal'),
(2210, 'vodka'),
(2211, 'vogue'),
(2212, 'voice'),
(2213, 'voila'),
(2214, 'vomit'),
(2215, 'voter'),
(2216, 'vouch'),
(2217, 'vowel'),
(2218, 'vying'),
(2219, 'wacky'),
(2220, 'wafer'),
(2221, 'wager'),
(2222, 'wagon'),
(2223, 'waist'),
(2224, 'waive'),
(2225, 'waltz'),
(2226, 'warty'),
(2227, 'waste'),
(2228, 'watch'),
(2229, 'water'),
(2230, 'waver'),
(2231, 'waxen'),
(2232, 'weary'),
(2233, 'weave'),
(2234, 'wedge'),
(2235, 'weedy'),
(2236, 'weigh'),
(2237, 'weird'),
(2238, 'welch'),
(2239, 'welsh'),
(2240, 'whack'),
(2241, 'whale'),
(2242, 'wharf'),
(2243, 'wheat'),
(2244, 'wheel'),
(2245, 'whelp'),
(2246, 'where'),
(2247, 'which'),
(2248, 'whiff'),
(2249, 'while'),
(2250, 'whine'),
(2251, 'whiny'),
(2252, 'whirl'),
(2253, 'whisk'),
(2254, 'white'),
(2255, 'whole'),
(2256, 'whoop'),
(2257, 'whose'),
(2258, 'widen'),
(2259, 'wider'),
(2260, 'widow'),
(2261, 'width'),
(2262, 'wield'),
(2263, 'wight'),
(2264, 'willy'),
(2265, 'wimpy'),
(2266, 'wince'),
(2267, 'winch'),
(2268, 'windy'),
(2269, 'wiser'),
(2270, 'wispy'),
(2271, 'witch'),
(2272, 'witty'),
(2273, 'woken'),
(2274, 'woman'),
(2275, 'women'),
(2276, 'woody'),
(2277, 'wooer'),
(2278, 'wooly'),
(2279, 'woozy'),
(2280, 'wordy'),
(2281, 'world'),
(2282, 'worry'),
(2283, 'worse'),
(2284, 'worst'),
(2285, 'worth'),
(2286, 'would'),
(2287, 'wound'),
(2288, 'woven'),
(2289, 'wrack'),
(2290, 'wrath'),
(2291, 'wreak'),
(2292, 'wreck'),
(2293, 'wrest'),
(2294, 'wring'),
(2295, 'wrist'),
(2296, 'write'),
(2297, 'wrong'),
(2298, 'wrote'),
(2299, 'wrung'),
(2300, 'wryly'),
(2301, 'yacht'),
(2302, 'yearn'),
(2303, 'yeast'),
(2304, 'yield'),
(2305, 'young'),
(2306, 'youth'),
(2307, 'zebra'),
(2308, 'zesty'),
(2309, 'zonal');
INSERT INTO "stats" ("id","games","wins","streak","max_streak") VALUES (1,0,0,0,0);