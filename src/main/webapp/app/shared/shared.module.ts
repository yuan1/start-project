import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { StartSharedLibsModule, StartSharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective } from './';

@NgModule({
  imports: [StartSharedLibsModule, StartSharedCommonModule],
  declarations: [JhiLoginModalComponent, HasAnyAuthorityDirective],
  entryComponents: [JhiLoginModalComponent],
  exports: [StartSharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class StartSharedModule {
  static forRoot() {
    return {
      ngModule: StartSharedModule
    };
  }
}
