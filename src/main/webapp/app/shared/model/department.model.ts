import { IEmployee } from 'app/shared/model/employee.model';

export interface IDepartment {
  id?: number;
  departmentName?: string;
  streetAddress?: string;
  locationId?: number;
  employees?: IEmployee[];
}

export class Department implements IDepartment {
  constructor(
    public id?: number,
    public departmentName?: string,
    public streetAddress?: string,
    public locationId?: number,
    public employees?: IEmployee[]
  ) {}
}
