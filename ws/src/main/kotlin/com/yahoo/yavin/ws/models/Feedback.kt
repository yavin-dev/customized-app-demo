/**
 * Copyright 2021 Yahoo Holdings Inc.
 * Licensed under the terms of the MIT license. See accompanying LICENSE.md file for terms.
 */
package com.yahoo.yavin.ws.models

import com.yahoo.elide.annotation.CreatePermission
import com.yahoo.elide.annotation.DeletePermission
import com.yahoo.elide.annotation.Include
import com.yahoo.elide.annotation.UpdatePermission
import com.yahoo.navi.ws.models.checks.DefaultEverybodyCheck.Companion.EVERYBODY
import com.yahoo.navi.ws.models.checks.DefaultNobodyCheck.Companion.NOBODY
import com.yahoo.navi.ws.models.beans.User
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne


@Entity
@Include(type = "feedbacks")
@CreatePermission(expression = EVERYBODY)
@DeletePermission(expression = NOBODY)
@UpdatePermission(expression = NOBODY)
class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0

    var title: String? = null

    var description: String? = null

    var type: String? = null

    var recommendationRating: Int = 0

    @ManyToOne
    var user: User? = null
}