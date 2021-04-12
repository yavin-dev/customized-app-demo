/**
 * Copyright 2021 Yahoo Holdings Inc.
 * Licensed under the terms of the MIT license. See accompanying LICENSE.md file for terms.
 */
import Route from '@ember/routing/route';
import { inject as service } from '@ember/service';
import User from 'navi-core/services/user';
import Feedback from 'yavin-ui/models/feedback';

export default class FeedbackRoute extends Route {
  @service
  declare user: User;

  model(): Feedback {
    const user = this.user.getUser();
    return this.store.createRecord('feedback', { user });
  }
}
