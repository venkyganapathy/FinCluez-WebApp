/*-----------------------------------------------------------------------------------------
This source is part of the Profinch Software Product. 

Copyright � 2017. All rights reserved. 

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
package com.profinch.fincluez.web.cards.controller;

import com.profinch.fincluez.core.cards.service.CardsCollectionTargetService;
import com.profinch.fincluez.entities.cards.CardsCollectionTarget;
import com.profinch.fincluez.entities.messageCodes.SuccessCodes;
import com.profinch.fincluez.entities.model.FinCluezException;
import com.profinch.fincluez.entities.requestModel.FinCluezRequest;
import com.profinch.fincluez.entities.responseModel.FinCluezResponse;
import com.profinch.fincluez.web.utils.FinCluezResponseUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/cardsCollectionTargetController")
public class CardsCollectionTargetController {

	public static final Logger log = LoggerFactory.getLogger(CardsCollectionTargetService.class);

	private CardsCollectionTargetService cardsCollectionTargetService;
	private FinCluezResponseUtility finCluezResponseUtility;

	@Autowired
	public CardsCollectionTargetController(CardsCollectionTargetService cardsCollectionTargetService, FinCluezResponseUtility finCluezResponseUtility) {
		this.cardsCollectionTargetService = cardsCollectionTargetService;
		this.finCluezResponseUtility = finCluezResponseUtility;
	}

	/*
	ObjectMapper objectMapper = new ObjectMapper();
	String stringifiedObject = objectMapper.writeValueAsString(finCluezRequest.getEntityList());
	List<CardsCollectionTarget> cardsCollectionTargetList = Arrays.asList(objectMapper.readValue(stringifiedObject, CardsCollectionTarget[].class));
	*/

	@RequestMapping(value = "/getAllCardsCollectionTarget", method = RequestMethod.POST)
	@ResponseBody
	public FinCluezResponse getAllCardsCollectionTarget	(@RequestBody FinCluezRequest finCluezRequest) throws Exception {
		log.info("getAllCardsCollectionTarget with Request {}",finCluezRequest);

		FinCluezResponse finCluezResponse;

		try {
			List<CardsCollectionTarget> cardsCollectionTargetList = cardsCollectionTargetService.getAllCardsCollectionTarget
					(finCluezRequest.getEntityCode(),
							finCluezRequest.getPageRequest().getCurrentPageNumber(),
							finCluezRequest.getPageRequest().getPageSize());

			finCluezResponse = finCluezResponseUtility.createSuccessResponseWithEntities(cardsCollectionTargetList, Collections.singletonList(SuccessCodes.S_GET_SUCCESS));
		} catch (FinCluezException fce) {
			log.error(fce.getErrorCode());
			finCluezResponse = finCluezResponseUtility.createErrorResponse(Collections.singletonList(fce.getErrorCode()));
		}

		return finCluezResponse;
	}

	@RequestMapping(value = "createCardsCollectionTarget", method = RequestMethod.POST)
	@ResponseBody
	public FinCluezResponse createCardsCollectionTarget(@RequestBody FinCluezRequest finCluezRequest) {
		log.info("createCardsCollectionTarget -- with -- Request {}", finCluezRequest);
		FinCluezResponse finCluezResponse;

		try {
			List<CardsCollectionTarget> cardsCollectionTargetList = cardsCollectionTargetService.createCardsCollectionTarget(finCluezRequest);
			finCluezResponse = finCluezResponseUtility.createSuccessResponseWithEntities(cardsCollectionTargetList, Collections.singletonList(SuccessCodes.S_CREATE_CARD_COLLECTION_TARGET_SUCCESS));
		} catch (FinCluezException e) {
			finCluezResponse = finCluezResponseUtility.createErrorResponse(Collections.singletonList(e.getErrorCode()));
		}

		finCluezResponse = finCluezResponseUtility.createSimpleSuccessResponse();
		return finCluezResponse;
	}
}
