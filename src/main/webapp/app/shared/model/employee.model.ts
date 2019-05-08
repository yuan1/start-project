import { Moment } from 'moment';
import { IJob } from 'app/shared/model/job.model';

export interface IEmployee {
  id?: number;
  firstName?: string;
  lastName?: string;
  email?: string;
  phoneNumber?: string;
  hireDate?: Moment;
  salary?: number;
  commissionPct?: number;
  departmentId?: number;
  departmentName?: string;
  jobs?: IJob[];
  managerId?: number;
  managerName?: string;
}

export class Employee implements IEmployee {
  constructor(
    public id?: number,
    public firstName?: string,
    public lastName?: string,
    public email?: string,
    public phoneNumber?: string,
    public hireDate?: Moment,
    public salary?: number,
    public commissionPct?: number,
    public departmentId?: number,
    public departmentName?: string,
    public jobs?: IJob[],
    public managerId?: number,
    public managerName?: string
  ) {}
}