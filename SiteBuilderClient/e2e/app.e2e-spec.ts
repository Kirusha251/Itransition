import { SiteBuilderClientPage } from './app.po';

describe('site-builder-client App', function() {
  let page: SiteBuilderClientPage;

  beforeEach(() => {
    page = new SiteBuilderClientPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
