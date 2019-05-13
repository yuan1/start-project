import { Moment } from 'moment';
import { ITask } from 'app/shared/model/task.model';

export const enum JobStatus {
  RELEASING = 'RELEASING',
  WORKING = 'WORKING',
  ENDING = 'ENDING'
}

export interface IJob {
  id?: number;
  jobTitle?: string;
  description?: string;
  minSalary?: number;
  maxSalary?: number;
  deliveryDate?: Moment;
  startDate?: Moment;
  endDate?: Moment;
  status?: JobStatus;
  employeeId?: number;
  employeeName?: string;
  tasks?: ITask[];
}

export class Job implements IJob {
  constructor(
    public id?: number,
    public jobTitle?: string,
    public description?: string,
    public minSalary?: number,
    public maxSalary?: number,
    public deliveryDate?: Moment,
    public startDate?: Moment,
    public endDate?: Moment,
    public status?: JobStatus,
    public employeeId?: number,
    public employeeName?: string,
    public tasks?: ITask[]
  ) {}
}
