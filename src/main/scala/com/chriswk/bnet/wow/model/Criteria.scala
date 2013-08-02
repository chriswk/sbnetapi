package com.chriswk.bnet.wow.model

/**
 * Criteria for achievement
 */
case class Criteria(description: String,
                    id: Long,
                    max: Long,
                    orderIndex: Long
                    )
