/**
 * Copyright 2021 Yahoo Holdings Inc.
 * Licensed under the terms of the MIT license. See accompanying LICENSE.md file for terms.
 */
import Model, { belongsTo } from '@ember-data/model';
import attr from 'ember-data/attr';
import type User from 'navi-core/models/user';

export default class Feedback extends Model {
  @attr('string')
  declare title: string;

  @attr('string')
  declare description: string;

  @attr('string')
  declare type: string;

  @attr('number')
  declare recommendationRating: number;

  @belongsTo('user')
  declare user: User;
}

// DO NOT DELETE: this is how TypeScript knows how to look up your models.
declare module 'ember-data/types/registries/model' {
  export default interface ModelRegistry {
    feedback: Feedback;
  }
}
