/*-----------------------------------------------------------------------------------------
This source is part of the Profinch Software Product. 
Copyright © 2018. All rights reserved. 

No part of this work may be reproduced, stored in a retrieval system, 
adopted or transmitted in any form or by any means, electronic, mechanical, 
photographic, graphic, optic recording or otherwise, translated in any language 
or computer language, without the prior written permission of Profinch Solutions Pvt Ltd. 

Profinch Solutions Pvt Ltd.
Wings of Eagles, SS Commercial Estate,
C V Raman Nagar, Bengaluru, Karnataka 560093

Modification History:
====================
Date		Version		Author			Description
----------	-----------	--------------- --------------------------------------------------------
11-08-2018	1.0			Naveen M D			Initial Version
------------------------------------------------------------------------------------------------*/
package com.profinch.fincluez.web.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.sql.DataSource;

@Configuration
@PropertySource(
		value = "file:${PROPERTY_PATH}", 
		factory = YamlPropertyLoaderFactory.class)
@EnableAsync
 public class DataSourceConfig { 
 
	
	@Value("${fincluez-webapp.datasource.url}")
	public String dataSourceUrl;
	
	@Value("${fincluez-webapp.datasource.username}")
	public String dataSourceUsername;
	
	@Value("${fincluez-webapp.datasource.password}")
	public String dataSourcePassword;
	
	@Value("${fincluez-webapp.datasource.driver}")
	public String dataSourceDriver;
	
    @Bean
    public DataSource dataSource() { 
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(dataSourceDriver);
        dataSource.setUrl(dataSourceUrl);
        dataSource.setUsername(dataSourceUsername);
        dataSource.setPassword(dataSourcePassword);
        return dataSource;
    }
}