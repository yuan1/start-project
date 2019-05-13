import { IEmployee } from 'app/shared/model/employee.model';

export interface IDepartment {
  id?: number;
  departmentName?: string;
  countryId?: number;
  countryName?: string;
  employees?: IEmployee[];
}

export class Department implements IDepartment {
  constructor(
    public id?: number,
    public departmentName?: string,
    public countryId?: number,
    public countryName?: string,
    public employees?: IEmployee[]
  ) {}
}
