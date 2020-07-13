/*--------------------------------------------------------------------------------------------------------------
This source is part of the Profinch Software Product. 
Copyright © 2019. All rights reserved. 

No part of this work may be reproduced, stored in a retrieval system, 
adopted or transmitted in any form or by any means, electronic, mechanical, 
photographic, graphic, optic recording or otherwise, translated in any language 
or computer language, without the prior written permission of Profinch Solutions Pvt Ltd. 

Profinch Solutions Pvt Ltd.
Wings of Eagles, SS Commercial Estate,
C V Raman Nagar, Bengaluru, Karnataka 560093

Modification History:
====================
Date		Version		Change Tag 		Author			Description
----------	-----------	--------------- --------------- --------------------------------------------------------
09-07-2020	3.1						    Venky G	        Initial Version
----------------------------------------------------------------------------------------------------------------*/
package com.profinch.fincluez.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class MessageSources {
	 
    @Bean
    public ResourceBundleMessageSource errorCodeSource() {
        ResourceBundleMessageSource errorCodeSource = new ResourceBundleMessageSource();
        errorCodeSource.setBasenames("messageSource/errorCodes");
        errorCodeSource.setUseCodeAsDefaultMessage(true);
        return errorCodeSource;
    }
    
    @Bean
    public ResourceBundleMessageSource successCodeSource() {
        ResourceBundleMessageSource successCodeSource = new ResourceBundleMessageSource();
        successCodeSource.setBasenames("messageSource/successCodes");
        successCodeSource.setUseCodeAsDefaultMessage(true);
        return successCodeSource;
    }

}
