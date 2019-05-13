import { Component, OnInit } from '@angular/core';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';
import { JhiAlertService } from 'ng-jhipster';
import { IJob, Job } from 'app/shared/model/job.model';
import { JobService } from './job.service';
import { IEmployee } from 'app/shared/model/employee.model';
import { EmployeeService } from 'app/entities/employee';

@Component({
  selector: 'jhi-job-update',
  templateUrl: './job-update.component.html'
})
export class JobUpdateComponent implements OnInit {
  job: IJob;
  isSaving: boolean;

  employees: IEmployee[];

  editForm = this.fb.group({
    id: [],
    jobTitle: [],
    description: [],
    minSalary: [],
    maxSalary: [],
    deliveryDate: [],
    startDate: [],
    endDate: [],
    status: [],
    employeeId: []
  });

  constructor(
    protected jhiAlertService: JhiAlertService,
    protected jobService: JobService,
    protected employeeService: EmployeeService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit() {
    this.isSaving = false;
    this.activatedRoute.data.subscribe(({ job }) => {
      this.updateForm(job);
      this.job = job;
    });
    this.employeeService
      .query()
      .pipe(
        filter((mayBeOk: HttpResponse<IEmployee[]>) => mayBeOk.ok),
        map((response: HttpResponse<IEmployee[]>) => response.body)
      )
      .subscribe((res: IEmployee[]) => (this.employees = res), (res: HttpErrorResponse) => this.onError(res.message));
  }

  updateForm(job: IJob) {
    this.editForm.patchValue({
      id: job.id,
      jobTitle: job.jobTitle,
      description: job.description,
      minSalary: job.minSalary,
      maxSalary: job.maxSalary,
      deliveryDate: job.deliveryDate != null ? job.deliveryDate.format(DATE_TIME_FORMAT) : null,
      startDate: job.startDate != null ? job.startDate.format(DATE_TIME_FORMAT) : null,
      endDate: job.endDate != null ? job.endDate.format(DATE_TIME_FORMAT) : null,
      status: job.status,
      employeeId: job.employeeId
    });
  }

  previousState() {
    window.history.back();
  }

  save() {
    this.isSaving = true;
    const job = this.createFromForm();
    if (job.id !== undefined) {
      this.subscribeToSaveResponse(this.jobService.update(job));
    } else {
      this.subscribeToSaveResponse(this.jobService.create(job));
    }
  }

  private createFromForm(): IJob {
    const entity = {
      ...new Job(),
      id: this.editForm.get(['id']).value,
      jobTitle: this.editForm.get(['jobTitle']).value,
      description: this.editForm.get(['description']).value,
      minSalary: this.editForm.get(['minSalary']).value,
      maxSalary: this.editForm.get(['maxSalary']).value,
      deliveryDate:
        this.editForm.get(['deliveryDate']).value != null ? moment(this.editForm.get(['deliveryDate']).value, DATE_TIME_FORMAT) : undefined,
      startDate:
        this.editForm.get(['startDate']).value != null ? moment(this.editForm.get(['startDate']).value, DATE_TIME_FORMAT) : undefined,
      endDate: this.editForm.get(['endDate']).value != null ? moment(this.editForm.get(['endDate']).value, DATE_TIME_FORMAT) : undefined,
      status: this.editForm.get(['status']).value,
      employeeId: this.editForm.get(['employeeId']).value
    };
    return entity;
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IJob>>) {
    result.subscribe((res: HttpResponse<IJob>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
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

  trackEmployeeById(index: number, item: IEmployee) {
    return item.id;
  }
}
