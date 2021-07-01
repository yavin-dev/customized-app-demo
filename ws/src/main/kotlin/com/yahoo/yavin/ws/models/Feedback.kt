/**
 * Copyright 2021 Yahoo Holdings Inc.
 * Licensed under the terms of the MIT license. See accompanying LICENSE.md file for terms.
 */
package com.yahoo.yavin.ws.models

import com.yahoo.elide.annotation.CreatePermission
import com.yahoo.elide.annotation.DeletePermission
import com.yahoo.elide.annotation.Include
import com.yahoo.elide.annotation.UpdatePermission
import com.yahoo.navi.ws.models.beans.User
import com.yahoo.navi.ws.models.checks.DefaultEverybodyCheck.Companion.EVERYBODY
import com.yahoo.navi.ws.models.checks.DefaultNobodyCheck.Companion.NOBODY
import org.hibernate.annotations.CreationTimestamp
import java.util.Date
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Temporal
import javax.persistence.TemporalType

@Entity
@Include(name = "feedbacks")
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

    @CreationTimestamp
    @Column(columnDefinition = "timestamp default current_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    @UpdatePermission(expression = NOBODY)
    var createdOn: Date? = null

    @ManyToOne
    var user: User? = null
}
