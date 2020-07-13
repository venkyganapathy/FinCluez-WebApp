/*-----------------------------------------------------------------------------------------
This source is part of the Profinch Software Product. 
Copyright © 2017. All rights reserved. 

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
18 05 2018	1.0			Sravanthi		Initial version
------------------------------------------------------------------------------------------------*/
package com.profinch.fincluez.entities.cards;

import com.profinch.fincluez.entities.constants.AuthStatus;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Getter
@Setter
@SequenceGenerator(name = "Seq_CardsCollectionTargetId", sequenceName = "Seq_CardsCollectionTargetId", initialValue = 1, allocationSize = 100)
public class CardsCollectionTarget implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "Seq_CardsCollectionTargetId")
	private BigDecimal id;
	private String cardType;
	private String delinquentBucket;
	private String entityCode;
	private BigDecimal targetCollection;
	@Version
	private int versionNo = 1;
	@Enumerated(EnumType.STRING)
	private AuthStatus authStatus;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}