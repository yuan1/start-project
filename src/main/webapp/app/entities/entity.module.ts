import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'region',
        loadChildren: './region/region.module#StartRegionModule'
      },
      {
        path: 'country',
        loadChildren: './country/country.module#StartCountryModule'
      },
      {
        path: 'department',
        loadChildren: './department/department.module#StartDepartmentModule'
      },
      {
        path: 'task',
        loadChildren: './task/task.module#StartTaskModule'
      },
      {
        path: 'job',
        loadChildren: './job/job.module#StartJobModule'
      },
      {
        path: 'employee',
        loadChildren: './employee/employee.module#StartEmployeeModule'
      },
      {
        path: 'job',
        loadChildren: './job/job.module#StartJobModule'
      },
      {
        path: 'department',
        loadChildren: './department/department.module#StartDepartmentModule'
      }
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ])
  ],
  declarations: [],
  entryComponents: [],
  providers: [],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class StartEntityModule {}
