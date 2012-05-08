-- phpMyAdmin SQL Dump
-- version 3.5.0
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2012 年 05 月 05 日 20:24
-- 服务器版本: 5.5.23
-- PHP 版本: 5.4.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `followher`
--

-- --------------------------------------------------------

--
-- 表的结构 `avatar`
--

CREATE TABLE IF NOT EXISTS `avatar` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `filelocation` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=11 ;

--
-- 转存表中的数据 `avatar`
--

INSERT INTO `avatar` (`id`, `filelocation`) VALUES
(1, 'Avatar/admin.jpeg'),
(2, 'Avatar/emma.png'),
(3, 'Avatar/banner.jpeg');

-- --------------------------------------------------------

--
-- 表的结构 `comment`
--

CREATE TABLE IF NOT EXISTS `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `postid` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `content` varchar(2000) DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `postid` (`postid`),
  KEY `userid` (`userid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=17 ;

--
-- 转存表中的数据 `comment`
--

INSERT INTO `comment` (`id`, `postid`, `userid`, `content`, `createtime`) VALUES
(1, 1, 2, 'Cool', '2012-06-04'),
(2, 3, 2, 'Fancy', '2012-06-04'),
(3, 6, 1, 'Oh My God', '2012-06-04'),
(4, 7, 1, 'Good', '2012-06-04'),
(5, 5, 1, 'Good', '2012-06-04');

-- --------------------------------------------------------

--
-- 表的结构 `fave`
--

CREATE TABLE IF NOT EXISTS `fave` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `postid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `postid` (`postid`),
  KEY `userid` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `generator_table`
--

CREATE TABLE IF NOT EXISTS `generator_table` (
  `ID` int(20) NOT NULL AUTO_INCREMENT,
  `G_KEY` varchar(50) DEFAULT NULL,
  `G_VALUE` int(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

--
-- 转存表中的数据 `generator_table`
--

INSERT INTO `generator_table` (`ID`, `G_KEY`, `G_VALUE`) VALUES
(1, 'AVATAR_PK', 4),
(2, 'USER_PK', 4),
(3, 'PROFILE_PK', 4),
(4, 'POST_PK', 10),
(5, 'COMMENT_PK', 6),
(6, 'IMG_PK', 12),
(11, 'TYPE_PK', 8),
(12, 'ITEM_PK', 27);

-- --------------------------------------------------------

--
-- 表的结构 `img`
--

CREATE TABLE IF NOT EXISTS `img` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(1000) DEFAULT NULL,
  `ebaylink` varchar(1000) DEFAULT NULL,
  `css` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=12 ;

--
-- 转存表中的数据 `img`
--

INSERT INTO `img` (`id`, `url`, `ebaylink`, `css`) VALUES
(1, 'poster/poster1.jpg', 'http://www.ebay.com', ''),
(2, 'poster/poster3.jpg', 'http://www.ebay.com', ''),
(3, 'poster/poster4.jpg', 'http://www.ebay.com', ''),
(4, 'poster/poster2.jpg', 'http://www.ebay.com', ''),
(5, 'poster/poster6.jpg', 'http://www.ebay.com', ''),
(6, 'poster/poster5.jpg', 'http://www.ebay.com', ''),
(7, 'poster/poster7.jpg', 'http://www.ebay.com', ''),
(8, 'poster/poster5.jpg', 'http://www.ebay.com', ''),
(9, 'poster/poster4.jpg', 'http://www.ebay.com', ''),
(10, 'poster/poster2.jpg', 'http://www.ebay.com', ''),
(11, 'poster/poster6.jpg', 'http://www.ebay.com', '');

-- --------------------------------------------------------

--
-- 表的结构 `imgpost`
--

CREATE TABLE IF NOT EXISTS `imgpost` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `postid` int(11) NOT NULL,
  `imgid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `postid` (`postid`),
  KEY `imgid` (`imgid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=12 ;

--
-- 转存表中的数据 `imgpost`
--

INSERT INTO `imgpost` (`id`, `postid`, `imgid`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(4, 4, 4),
(5, 5, 5),
(6, 6, 6),
(7, 7, 7),
(8, 8, 8),
(9, 8, 9),
(10, 9, 10),
(11, 9, 11);

-- --------------------------------------------------------

--
-- 表的结构 `items`
--

CREATE TABLE IF NOT EXISTS `items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) NOT NULL,
  `filelocation` varchar(100) DEFAULT NULL,
  `ebaylink` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `type` (`type`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=27 ;

--
-- 转存表中的数据 `items`
--

INSERT INTO `items` (`id`, `type`, `filelocation`, `ebaylink`) VALUES
(1, 1, 'CSA/Coats_Jackets/Coats_Jackets1.jpg', 'http://www.ebay.com/itm/New-Michael-Kors-Double-Breasted-Pea-Coat-Winter-Wool-Jacket-For-Women-in-Black-/200723582912#ht_1487wt_1064'),
(2, 1, 'CSA/Coats_Jackets/Coats_Jackets2.jpg', 'http://www.ebay.com/itm/NWT-WOMEN-SZ-XS-1-2-OLD-NAVY-BLUE-CROPPED-TRENCH-PEA-COAT-SPRING-FALL-JACKET-NEW-/300701986809#ht_1462wt_1051'),
(3, 1, 'CSA/Coats_Jackets/Coats_Jackets3.jpg', 'http://www.ebay.com/itm/Old-Navy-faux-shearling-motorcycle-bomber-jacket-med-/200750798508#ht_500wt_1068'),
(4, 2, 'CSA/Dresses/Dresses1.jpg', 'http://www.ebay.com/itm/Berry-Twist-Front-Layered-Dress-Jasmine-Size-8-New-/320896395742#ht_897wt_1139'),
(5, 2, 'CSA/Dresses/Dresses2.jpg', 'http://www.ebay.com/itm/Beige-Short-Sleeve-Career-Pencil-Dress-Belt-Size-12-New-/330724258801#ht_996wt_1139'),
(6, 2, 'CSA/Dresses/Dresses3.jpg', 'http://www.ebay.com/itm/Mocha-Black-Graphic-Art-Print-Tunic-Dress-Size-10-New-/320896393233#ht_1728wt_1139'),
(7, 2, 'CSA/Dresses/Dresses4.jpg', 'http://www.ebay.com/itm/Leopard-print-long-cotton-chiffon-dress-/120902793017#ht_1347wt_952'),
(8, 3, 'CSA/Jeans/Jeans1.jpg', 'http://www.ebay.com/itm/Label-Lab-Skinny-Biker-Jeans-In-Nearly-Black-/120906570794'),
(9, 3, 'CSA/Jeans/Jeans2.jpg', 'http://www.ebay.com/itm/NEW-LADIES-WOMENS-SKINNY-SLIM-FIT-STITCH-DETAIL-DENIM-BLUE-JEANS-6-8-10-12-14-/230785077068'),
(10, 3, 'CSA/Jeans/Jeans3.jpg', 'http://www.ebay.com/itm/PILCRO-BY-ANTHROPOLOGIE-Grey-Mid-Rise-Bootcut-Jeans-Sz-Tag-Missing-/261015773327#ht_1092wt_1185'),
(11, 3, 'CSA/Jeans/Jeans4.jpg', 'http://www.ebay.com/itm/ROXY-Dark-Blue-Low-Rise-Bootcut-Jeans-Sz-1-/261015774077#ht_1092wt_1185'),
(12, 4, 'CSA/pants/pants1.jpg', 'http://www.ebay.com/itm/NWT-LARGE-NIKE-Womens-Dri-Fit-Lowrise-WorkOut-Pants-SHORT-LENGTH-petite-/200750638635#ht_1236wt_308'),
(13, 4, 'CSA/pants/pants2.jpg', 'http://www.ebay.com/itm/New-Girl-Dickies-Black-Two-Back-Welt-Pocket-Pant-N882-The-Worker-NWT-With-Tags-/190664106433#ht_1689wt_952'),
(14, 4, 'CSA/pants/pants3.jpg', 'http://www.ebay.com/itm/Pied-a-Terre-Paperbag-Trousers-In-Black-/140746868932#ht_1099wt_1139'),
(15, 5, 'CSA/shoes/shoes1.jpg', 'http://www.ebay.com/itm/2012-Hot-Sexy-Womens-High-Heel-Shoes-Pump-Platform-Four-Sizes-US5-US8-35-39-/270967849039#ht_8698wt_1139'),
(16, 5, 'CSA/shoes/shoes2.jpg', 'http://www.ebay.com/itm/Privo-Womens-Polar-Lake-Slip-On-Sz-10N-/170835354968#ht_2162wt_1139'),
(17, 5, 'CSA/shoes/shoes3.jpg', 'http://www.ebay.com/itm/Nine-West-Womens-Captivate-Sandals-/180869734952#ht_500wt_1202'),
(18, 5, 'CSA/shoes/shoes4.jpg', 'http://www.ebay.com/itm/Nike-Womens-NIKE-AIR-KARST-Z-WOMENS-BOOTS-red-/190671220609#ht_500wt_1202'),
(19, 5, 'CSA/shoes/shoes5.jpg', 'http://www.ebay.com/itm/Dereon-Sasho-Womens-SZ-7-Black-Shoes-/140747396642#ht_2435wt_1185'),
(20, 6, 'CSA/Skirts/Skirts1.jpg', 'http://www.ebay.com/itm/Linea-Lace-Skirt-In-Off-White-/110872805345'),
(21, 6, 'CSA/Skirts/Skirts2.jpg', 'http://www.ebay.com/itm/Yumi-Floral-Maxi-Skirt-In-Black-/120906628406'),
(22, 6, 'CSA/Skirts/Skirts3.jpg', 'http://www.ebay.com/itm/Retro-Lace-Skirt-Crochet-bottoming-Skirt-Bouffant-Puffy-Dress-6-Colors-S074-/180869835540#ht_7548wt_1110'),
(23, 6, 'CSA/Skirts/Skirts4.jpg', 'http://www.ebay.com/itm/aeropostale-aero-87-script-graphic-t-/110873340270'),
(24, 7, 'CSA/Tops/Tops1.jpg', 'http://www.ebay.com/itm/Free-Ship-Women-Cotton-Miss-Vest-Mini-Dress-T-shirt-Sleeveless-Tops-434-Size-S-/230781672781#ht_7300wt_1090'),
(25, 7, 'CSA/Tops/Tops2.jpg', 'http://www.ebay.com/itm/Free-Ship-Women-Cotton-Miss-Vest-Mini-Dress-T-shirt-Sleeveless-Tops-434-Size-S-/230781672781#ht_7300wt_1090'),
(26, 7, 'CSA/Tops/Tops3.jpg', 'http://www.ebay.com/itm/September-11th-Firefighters-Emblem-10-Years-Never-Forget-Junior-Girls-T-shirt-/320761513933');

-- --------------------------------------------------------

--
-- 表的结构 `like`
--

CREATE TABLE IF NOT EXISTS `like` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `postid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `postid` (`postid`),
  KEY `userid` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `post`
--

CREATE TABLE IF NOT EXISTS `post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(2000) DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

--
-- 转存表中的数据 `post`
--

INSERT INTO `post` (`id`, `content`, `createtime`) VALUES
(1, 'Oh,Cool!!!', '2012-06-04'),
(2, 'U deserve it!', '2012-06-03'),
(3, 'Good,Cool!', '2012-06-10'),
(4, 'Cool,beautiful, fancy !', '2012-06-03'),
(5, 'Fancy,Cool', '2012-07-04'),
(6, 'Good,Cool!!!!', '2012-05-04'),
(7, 'Good,Cool!!!', '2012-06-01'),
(8, 'Good,Cool!!!', '2012-06-04'),
(9, 'Good,fancy!!!', '2012-06-04');

-- --------------------------------------------------------

--
-- 表的结构 `profile`
--

CREATE TABLE IF NOT EXISTS `profile` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=11 ;

--
-- 转存表中的数据 `profile`
--

INSERT INTO `profile` (`id`, `password`) VALUES
(1, '123456'),
(2, '123456'),
(3, '123456');

-- --------------------------------------------------------

--
-- 表的结构 `subscribe`
--

CREATE TABLE IF NOT EXISTS `subscribe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `followid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  KEY `followid` (`followid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- 表的结构 `type`
--

CREATE TABLE IF NOT EXISTS `type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- 转存表中的数据 `type`
--

INSERT INTO `type` (`id`, `type`) VALUES
(1, 'coats_jacketS'),
(2, 'dresses'),
(3, 'jeans'),
(4, 'pants'),
(5, 'shoes'),
(6, 'skirts'),
(7, 'tops');

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `avatar` int(11) NOT NULL,
  `profile` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `avatar` (`avatar`),
  KEY `profile` (`profile`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- 转存表中的数据 `user`
--

INSERT INTO `user` (`id`, `avatar`, `profile`, `name`, `sex`) VALUES
(1, 1, 1, 'admin', 'female'),
(2, 2, 2, 'Emma', 'female'),
(3, 3, 3, 'Banner', 'male');

-- --------------------------------------------------------

--
-- 表的结构 `userpost`
--

CREATE TABLE IF NOT EXISTS `userpost` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `postid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  KEY `postid` (`postid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=16 ;

--
-- 转存表中的数据 `userpost`
--

INSERT INTO `userpost` (`id`, `userid`, `postid`) VALUES
(7, 3, 6),
(8, 3, 7),
(9, 2, 4),
(10, 2, 5),
(11, 2, 8),
(12, 1, 1),
(13, 1, 2),
(14, 1, 3),
(15, 1, 9);

--
-- 限制导出的表
--

--
-- 限制表 `fave`
--
ALTER TABLE `fave`
  ADD CONSTRAINT `fave_ibfk_1` FOREIGN KEY (`postid`) REFERENCES `post` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fave_ibfk_2` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- 限制表 `imgpost`
--
ALTER TABLE `imgpost`
  ADD CONSTRAINT `imgpost_ibfk_1` FOREIGN KEY (`postid`) REFERENCES `post` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `imgpost_ibfk_2` FOREIGN KEY (`imgid`) REFERENCES `img` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- 限制表 `items`
--
ALTER TABLE `items`
  ADD CONSTRAINT `items_ibfk_1` FOREIGN KEY (`type`) REFERENCES `type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- 限制表 `like`
--
ALTER TABLE `like`
  ADD CONSTRAINT `like_ibfk_1` FOREIGN KEY (`postid`) REFERENCES `post` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `like_ibfk_2` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- 限制表 `subscribe`
--
ALTER TABLE `subscribe`
  ADD CONSTRAINT `subscribe_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `subscribe_ibfk_2` FOREIGN KEY (`followid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- 限制表 `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`avatar`) REFERENCES `avatar` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `user_ibfk_2` FOREIGN KEY (`profile`) REFERENCES `profile` (`id`) ON UPDATE CASCADE;

--
-- 限制表 `userpost`
--
ALTER TABLE `userpost`
  ADD CONSTRAINT `userpost_ibfk_1` FOREIGN KEY (`postid`) REFERENCES `post` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `userpost_ibfk_2` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
