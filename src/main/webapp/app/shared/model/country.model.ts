import { IDepartment } from 'app/shared/model/department.model';

export interface ICountry {
  id?: number;
  countryName?: string;
  regionId?: number;
  departments?: IDepartment[];
  regionName?: string;
}

export class Country implements ICountry {
  constructor(
    public id?: number,
    public countryName?: string,
    public regionId?: number,
    public regionName?: string,
    public departments?: IDepartment[]
  ) {}
}
