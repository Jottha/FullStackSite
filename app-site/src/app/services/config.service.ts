export class ConfigService {

    private urlService: string;

    constructor() {
        this.urlService = 'http://localhost:8090/controller';
    }

    getUrlService(): string {

        return this.urlService;
    }
}