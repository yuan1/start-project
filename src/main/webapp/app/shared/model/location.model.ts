export interface ILocation {
  id?: number;
  streetAddress?: string;
  postalCode?: string;
  city?: string;
  stateProvince?: string;
  countryId?: number;
  countryName?: string;
}

export class Location implements ILocation {
  constructor(
    public id?: number,
    public streetAddress?: string,
    public postalCode?: string,
    public city?: string,
    public stateProvince?: string,
    public countryId?: number,
    public countryName?: string
  ) {}
}
