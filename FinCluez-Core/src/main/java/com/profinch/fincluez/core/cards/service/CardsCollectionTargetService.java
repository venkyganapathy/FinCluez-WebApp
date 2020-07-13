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
package com.profinch.fincluez.core.cards.service;

import java.util.Arrays;
import java.util.List;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.profinch.fincluez.core.cards.repo.CardsCollectionTargetRepo;
import com.profinch.fincluez.entities.cards.CardsCollectionTarget;
import com.profinch.fincluez.entities.constants.AuthStatus;
import com.profinch.fincluez.entities.messageCodes.ErrorCodes;
import com.profinch.fincluez.entities.model.FinCluezException;
import com.profinch.fincluez.entities.requestModel.FinCluezRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class CardsCollectionTargetService
{
	public static final Logger log = LoggerFactory.getLogger(CardsCollectionTargetService.class);

	private CardsCollectionTargetRepo cardsCollectionTargetRepo;

	@Autowired
	public CardsCollectionTargetService(CardsCollectionTargetRepo cardsCollectionTargetRepo) {
		this.cardsCollectionTargetRepo = cardsCollectionTargetRepo;
	}

	public List<CardsCollectionTarget> getAllCardsCollectionTarget(String entityCode, Integer currentPage, Integer pageSize) throws FinCluezException{
		log.debug("inside...Service -- getAllCardsCollectionTarget with entityCode -->{} and pageNum {}",entityCode,currentPage);
		List<CardsCollectionTarget> cardsCollectionTargetList = null;
		try {
			Pageable pageable = PageRequest.of(currentPage,pageSize);
			cardsCollectionTargetList = cardsCollectionTargetRepo.findAllByEntityCode(entityCode,pageable);
			log.debug("Found CardsCollectionTarget....{}",cardsCollectionTargetList);
		} catch (Exception e) {
			log.error("getAllCardsCollectionTarget..");
		}
		return cardsCollectionTargetList;
	}
	
	public List<CardsCollectionTarget> createCardsCollectionTarget(FinCluezRequest finCluezRequest) throws FinCluezException {
		log.debug("inside...Service -- createCardsCollectionTarget with finCluezRequest {}",finCluezRequest);

		List<CardsCollectionTarget> cardsCollectionTargetList = null;
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String stringifiedObject = objectMapper.writeValueAsString(finCluezRequest.getEntityList());
			cardsCollectionTargetList = Arrays.asList(objectMapper.readValue(stringifiedObject, CardsCollectionTarget[].class));
		} catch (JsonProcessingException e) {
			log.debug("JSON Parsing Exception in createCardsCollectionTarget");
			throw new FinCluezException(ErrorCodes.E_CARD_COLLECTION_TARGET_CREATION_FAILURE,finCluezRequest.getLanguage());
		}
		cardsCollectionTargetList = (List<CardsCollectionTarget>) cardsCollectionTargetRepo.saveAll(cardsCollectionTargetList);
		return cardsCollectionTargetList;
	}

	public List<CardsCollectionTarget> updateCardsCollectionTarget(List<CardsCollectionTarget> cardsCollectionTargetList) throws FinCluezException {
		log.debug("inside...Service -- updateCardsCollectionTarget with {}",cardsCollectionTargetList);
		cardsCollectionTargetList = (List<CardsCollectionTarget>) cardsCollectionTargetRepo.saveAll(cardsCollectionTargetList);
		return cardsCollectionTargetList;
	}
	
	public void deleteCardsCollectionTarget(List<CardsCollectionTarget> cardsCollectionTargetList) throws Exception {
		log.debug("inside...Service -- deleteCardsCollectionTarget with {}",cardsCollectionTargetList);
		cardsCollectionTargetRepo.deleteAll(cardsCollectionTargetList);
	}

	public List<CardsCollectionTarget> authCardsCollectionTarget(List<CardsCollectionTarget> cardsCollectionTargetList) throws FinCluezException {
		log.debug("inside...Service -- authCardsCollectionTarget with {}",cardsCollectionTargetList);
		for (CardsCollectionTarget cardsCollectionTarget:cardsCollectionTargetList){
			cardsCollectionTarget.setAuthStatus(AuthStatus.AUTHORIZED);
		}
		cardsCollectionTargetList = (List<CardsCollectionTarget>) cardsCollectionTargetRepo.saveAll(cardsCollectionTargetList);
		return cardsCollectionTargetList;
	}
	
}

