import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DivboxComponent } from './divbox.component';

describe('DivboxComponent', () => {
  let component: DivboxComponent;
  let fixture: ComponentFixture<DivboxComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DivboxComponent]
    });
    fixture = TestBed.createComponent(DivboxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
