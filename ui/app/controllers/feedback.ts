/**
 * Copyright 2021 Yahoo Holdings Inc.
 * Licensed under the terms of the MIT license. See accompanying LICENSE.md file for terms.
 */
import Controller from '@ember/controller';
import { action } from '@ember/object';
import { inject as service } from '@ember/service';
import type Feedback from 'yavin-ui/models/feedback';
import type NaviNotifications from 'navi-notifications/services/navi-notifications';

export default class FeedbackController extends Controller {
  declare model: Feedback;

  @service
  declare naviNotifications: NaviNotifications;

  @action
  setTitle({ target }: { target: HTMLInputElement }): void {
    this.model.set('title', target?.value);
  }

  @action
  setDescription({ target }: { target: HTMLInputElement }): void {
    this.model.set('description', target?.value);
  }

  @action
  setType(type: string): void {
    this.model.set('type', type);
  }

  @action
  setRating(rating: number): void {
    this.model.set('recommendationRating', rating);
  }

  @action
  async submit(): Promise<void> {
    try {
      await this.model.save();
      this.naviNotifications.add({
        title: 'Thank you for your feedback',
        style: 'success',
      });
      this.transitionToRoute('index');
    } catch (e) {
      this.naviNotifications.add({
        title: 'An error occurred while submitting feedback',
        style: 'danger',
      });
    }
  }
}

// DO NOT DELETE: this is how TypeScript knows how to look up your controllers.
declare module '@ember/controller' {
  export default interface Registry {
    feedback: Feedback;
  }
}
