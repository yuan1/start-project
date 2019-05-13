import { Component, OnInit } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { JhiAlertService } from 'ng-jhipster';
import { IDepartment, Department } from 'app/shared/model/department.model';
import { DepartmentService } from './department.service';
import { ICountry } from 'app/shared/model/country.model';
import { CountryService } from 'app/entities/country';

@Component({
  selector: 'jhi-department-update',
  templateUrl: './department-update.component.html'
})
export class DepartmentUpdateComponent implements OnInit {
  department: IDepartment;
  isSaving: boolean;

  countries: ICountry[];

  editForm = this.fb.group({
    id: [],
    departmentName: [null, [Validators.required]],
    countryId: []
  });

  constructor(
    protected jhiAlertService: JhiAlertService,
    protected departmentService: DepartmentService,
    protected countryService: CountryService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit() {
    this.isSaving = false;
    this.activatedRoute.data.subscribe(({ department }) => {
      this.updateForm(department);
      this.department = department;
    });
    this.countryService
      .query({ filter: 'department-is-null' })
      .pipe(
        filter((mayBeOk: HttpResponse<ICountry[]>) => mayBeOk.ok),
        map((response: HttpResponse<ICountry[]>) => response.body)
      )
      .subscribe(
        (res: ICountry[]) => {
          if (!this.department.countryId) {
            this.countries = res;
          } else {
            this.countryService
              .find(this.department.countryId)
              .pipe(
                filter((subResMayBeOk: HttpResponse<ICountry>) => subResMayBeOk.ok),
                map((subResponse: HttpResponse<ICountry>) => subResponse.body)
              )
              .subscribe(
                (subRes: ICountry) => (this.countries = [subRes].concat(res)),
                (subRes: HttpErrorResponse) => this.onError(subRes.message)
              );
          }
        },
        (res: HttpErrorResponse) => this.onError(res.message)
      );
  }

  updateForm(department: IDepartment) {
    this.editForm.patchValue({
      id: department.id,
      departmentName: department.departmentName,
      countryId: department.countryId
    });
  }

  previousState() {
    window.history.back();
  }

  save() {
    this.isSaving = true;
    const department = this.createFromForm();
    if (department.id !== undefined) {
      this.subscribeToSaveResponse(this.departmentService.update(department));
    } else {
      this.subscribeToSaveResponse(this.departmentService.create(department));
    }
  }

  private createFromForm(): IDepartment {
    const entity = {
      ...new Department(),
      id: this.editForm.get(['id']).value,
      departmentName: this.editForm.get(['departmentName']).value,
      countryId: this.editForm.get(['countryId']).value
    };
    return entity;
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IDepartment>>) {
    result.subscribe((res: HttpResponse<IDepartment>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
  }

  protected onSaveSuccess() {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError() {
    this.isSaving = false;
  }
  protected onError(errorMessage: string) {
    this.jhiAlertService.error(errorMessage, null, null);
  }

  trackCountryById(index: number, item: ICountry) {
    return item.id;
  }
}
