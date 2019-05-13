import { Moment } from 'moment';

export const enum TaskStatus {
  RELEASING = 'RELEASING',
  PAUSING = 'PAUSING',
  WORKING = 'WORKING',
  ENDING = 'ENDING'
}

export interface ITask {
  id?: number;
  title?: string;
  description?: string;
  startDate?: Moment;
  endDate?: Moment;
  status?: TaskStatus;
  jobId?: number;
  jobTitle?: string;
}

export class Task implements ITask {
  constructor(
    public id?: number,
    public title?: string,
    public description?: string,
    public startDate?: Moment,
    public endDate?: Moment,
    public status?: TaskStatus,
    public jobId?: number,
    public jobTitle?: string
  ) {}
}
