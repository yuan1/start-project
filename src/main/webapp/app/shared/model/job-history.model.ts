import { Moment } from 'moment';

export const enum Language {
  CHINESE = 'CHINESE',
  ENGLISH = 'ENGLISH',
  SPANISH = 'SPANISH'
}

export interface IJobHistory {
  id?: number;
  startDate?: Moment;
  endDate?: Moment;
  language?: Language;
  jobId?: number;
  jobTitle?: string;
  departmentId?: number;
  departmentName?: string;
  employeeId?: number;
  employeeName?: string;
}

export class JobHistory implements IJobHistory {
  constructor(
    public id?: number,
    public startDate?: Moment,
    public endDate?: Moment,
    public language?: Language,
    public jobId?: number,
    public jobTitle?: string,
    public departmentId?: number,
    public departmentName?: string,
    public employeeId?: number,
    public employeeName?: string
  ) {}
}
