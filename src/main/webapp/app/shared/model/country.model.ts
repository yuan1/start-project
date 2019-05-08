export interface ICountry {
  id?: number;
  countryName?: string;
  regionId?: number;
  regionName?: string;
}

export class Country implements ICountry {
  constructor(public id?: number, public countryName?: string, public regionId?: number, public regionName?: string) {}
}
