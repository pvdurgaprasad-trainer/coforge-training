import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Librarian } from './librarian';

describe('Librarian', () => {
  let component: Librarian;
  let fixture: ComponentFixture<Librarian>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Librarian]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Librarian);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
