CREATE TABLE `product` (
  `product_id` bigint(20) unsigned NOT NULL COMMENT '产品id',
  `product_name` varchar(128) DEFAULT '' COMMENT '产品名称',
  `inventory_cnt` int(11) DEFAULT '0' COMMENT '库存数量',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

