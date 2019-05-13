import { IJob } from 'app/shared/model/job.model';

export interface IEmployee {
  id?: number;
  login?: string;
  firstName?: string;
  lastName?: string;
  email?: string;
  phoneNumber?: string;
  salary?: number;
  departmentId?: number;
  departmentName?: string;
  userId?: number;
  jobs?: IJob[];
}

export class Employee implements IEmployee {
  constructor(
    public id?: number,
    public login?: string,
    public firstName?: string,
    public lastName?: string,
    public email?: string,
    public phoneNumber?: string,
    public salary?: number,
    public departmentId?: number,
    public departmentName?: string,
    public userId?: number,
    public jobs?: IJob[]
  ) {}
}
