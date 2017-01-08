import { BraiFuckClientPage } from './app.po';

describe('brai-fuck-client App', function() {
  let page: BraiFuckClientPage;

  beforeEach(() => {
    page = new BraiFuckClientPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
