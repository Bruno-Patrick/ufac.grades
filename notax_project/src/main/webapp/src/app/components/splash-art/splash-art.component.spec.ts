import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SplashArtComponent } from './splash-art.component';

describe('SplashArtComponent', () => {
  let component: SplashArtComponent;
  let fixture: ComponentFixture<SplashArtComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SplashArtComponent]
    });
    fixture = TestBed.createComponent(SplashArtComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
